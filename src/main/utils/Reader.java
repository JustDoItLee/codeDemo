package toos.exclUtil;

import com.third_party_app.attendance.po.Record;
import com.third_party_app.attendance.po.Person;
import org.apache.poi.ss.usermodel.*;
import toos.dayUtil.DayUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.*;

public class Reader {

    private static String uNo;

    public static Map<String, Object> readExecl(String filePath, Calendar calendar){

        Map<String, Object> map = new HashMap<>();
        String department = "";
        List<Person> persons = new ArrayList<>();
        List<Record> records = new ArrayList<>();

        //解析传入的excel文件
        try{
            InputStream is = new FileInputStream(new File(filePath));
            //根据输入流创建Workbook对象
            Workbook wb = WorkbookFactory.create(is);
            //get到Sheet对象
            Sheet sheet = wb.getSheetAt(0);

            //逐行逐列的解析excel
            for(int i = 2; i < sheet.getLastRowNum(); i++){

                Row row = sheet.getRow(i);
                Person person = new Person();
                Cell cell_1 = row.getCell(0);

                if(cell_1 != null && !"".equals(cell_1.getRichStringCellValue().toString())) {
                    department = cell_1.getRichStringCellValue().toString();
                }
                int days = DayUtil.maxDays(calendar);
                for(int j = 1;j < row.getLastCellNum() && j < days + 4; j++){
                    //设置当前单元格的日期
                    Date date = calendar.getTime();
                    if(j > 3){
                        date.setDate(j-3);
                    }
                    Record record = new Record();
                    Cell cell = row.getCell(j);

                    //生成 person 和 record 的 pojo
                    if(j < 4) {
                        person = buildPerson(cell, person, department, j);
                        if (null == person){
                            uNo = null;
                            break;
                        }
                    }else {
                        if (uNo == null || "".equals(uNo)){
                            continue;
                        }
                        record = buildRecord(cell, record, date);
                        records.add(record);
                    }
                }
                if(person != null && !"".equals(person.getuNo())) {
                    persons.add(person);
                }

            }
        }catch (Exception e){
            e.printStackTrace();
        }
        //加入并返回map
        map.put("persons", persons);
        map.put("records", records);
        return map;
    }

    //生成pojo
    private static Person buildPerson(Cell cell, Person person,
                                    String department, int cellIndex){

        String cellString;
        if (cell != null && !"".equals(cell.getRichStringCellValue().toString())){
            cellString = cell.getRichStringCellValue().toString();
        }else {
            return null;
        }

        if(cellIndex == 1) {
            person.setuName(cellString);
            person.setDepartment(department);
            person.setCompany("");

        }else if (cellIndex == 2) {
            try {
                int post = Integer.parseInt(cellString);
                person.setPost(post);
            }catch (Exception e) {
                person.setPost(0);
            }
        }else if (cellIndex == 3) {
            person.setuNo(cellString);
        }
        uNo = person.getuNo();

        return person;
    }

    private static Record buildRecord(Cell cell, Record record,
                                    Date date){
        try {
            //获取当前单元格的内容并获取长度
            String cellString = cell.getRichStringCellValue().toString();
            int cellStringLength = cellString.length();
            record.setShortLeave("");
            //如果单元格长度小于五 则抛出异常（正确时间格式为00:00，如果不是，则认为是错误的）
            if(cellStringLength < 5) {
                throw new Exception();
                /**
                 * 如果单元格长度仅为五（只有一次打卡记录
                 * 则判断该打卡时间是上午还是下午打卡
                 */
            }else if(cellStringLength == 5){
                if(timeSelect(cellString) == 1){
                    record.setSignIn(cellString.substring(0, 5));
                    record.setSignOut("");

                }else {
                    record.setSignIn("");
                    record.setSignOut(cellString.substring(0, 5));

                }

                /**
                 * 有两到三次打卡记录
                 * 前提条件：
                 * 三次打卡仅仅判断第一次和最后一次打卡时间
                 * 规则如下：
                 * 1.如果第一次打卡时间是上午,则判断最后一次打卡的时间如果是上午，则空出下午的时间，
                 *      即将两次打卡时间都放在signIn, 让signOut空出来以备判断是否请假。
                 * 2.如果第一次打卡时间是下午，则将两次打卡时间都放入signOut，让signIn空出来以备判断是否请假。
                 * 3.如果一次上午一次下午，则正常记录
                 */
            }else if(cellStringLength >= 10 && cellStringLength <= 15){
                String firstSign = cellString.substring(0, 5);
                String lastSign = cellString.substring(cellStringLength - 5, cellStringLength);

                if (timeSelect(firstSign.substring(0, 2)) == 1 && timeSelect(lastSign.substring(0, 2)) == 1){
                    record.setSignIn(cellString);
                    record.setSignOut("");

                }else if (timeSelect(firstSign.substring(0, 2)) == 2){
                    record.setSignIn("");
                    record.setSignOut(cellString);

                }else {
                    record.setSignIn(firstSign);
                    record.setSignOut(lastSign);
                }

            }else if(cellStringLength == 20) {
                record.setSignIn(cellString.substring(0, 5));
                record.setSignOut(cellString.substring(cellStringLength - 5, cellStringLength));
                record.setShortLeave(cellString.substring(6,15));
            }

        }catch (Exception e) {
            record.setSignIn("");
            record.setSignOut("");
            record.setShortLeave("");

        }finally {
            record.setuNo(uNo);
            record.setDay(date);

        }
        return record;
    }

    public static int timeSelect(String time) {
        time = time.substring(0,2);
        int exactTime = Integer.parseInt(time);

        //判断是上午还是下午  上午：1 / 下午：2
        if(exactTime < 12){
            return 1;
        }else {
            return 2;
        }
    }
}