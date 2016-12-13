package main.utils;

import com.third_party_app.attendance.po.Person;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

public class Writer {

    public static String buildExcel(List<Person> persons,Map<String,Integer> departmentLengths) throws IOException {

        //创建Workbook对象（这一个对象代表着对应的一个Excel文件）
        //HSSFWorkbook表示以xls为后缀名的文件
        Workbook wb = new HSSFWorkbook();
        //获得CreationHelper对象,这个应该是一个帮助类
        CreationHelper helper = wb.getCreationHelper();
        //创建Sheet并给名字(表示Excel的一个Sheet)
        Sheet sheet1 = wb.createSheet("model");
        //Row表示一行Cell表示一列
        Row row = null;
        Cell cell = null;

        //设置标题 考勤记录模板
        //设置要合并的单元格
        CellRangeAddress cra = new CellRangeAddress(0, 1, 0, 34);
        //将合并的单元格加入到表中
        sheet1.addMergedRegion(cra);
        //取得该单元格
        Row title = sheet1.createRow(0);
        Cell cell_1 = title.createCell(0);
        //设置样式
        CellStyle cellStyle_1 = Writer.createStyleCell(wb);
        cellStyle_1 = setCellStyleAlignment(cellStyle_1);
        Font font_1 = wb.createFont();
        font_1.setFontHeightInPoints((short) 20);
        cellStyle_1.setFont(font_1);
        cell_1.setCellStyle(cellStyle_1);
        //设置值
        cell_1.setCellValue("考勤记录模板");

        //画出表头
        Row head = sheet1.createRow(2);
        for (int i = 0; i < 35; i ++) {
            Cell cell_2 = head.createCell(i);
            CellStyle cellStyle_2 = Writer.createStyleCell(wb);
            cellStyle_2 = setCellStyleAlignment(cellStyle_2);
            cellStyle_2.setFont(createFonts(wb));
            cell_2.setCellStyle(cellStyle_2);
            int ifIsDate = i - 3;
            switch (i){
                case 0 : cell_2.setCellValue("部门");break;
                case 1 : cell_2.setCellValue("姓名");break;
                case 2 : cell_2.setCellValue("是否领导");break;
                case 3 : cell_2.setCellValue("员工编号");break;
                default : cell_2.setCellValue(ifIsDate);break;
            }
        }

        //创建一个基本的样式
        CellStyle cellStyle = Writer.createStyleCell(wb);
        cellStyle = Writer.setCellStyleAlignment(cellStyle);
        cellStyle.setFont(createFonts(wb));
        //初始化设置要合并的单元格的第一行
        int lastCellIndex = 3;

        //定义部门名字和人数
        String dpmtName;
        Integer dpmtNum;
        //画出主体
        for(int i = 0; i < persons.size(); i ++){
            Person person = persons.get(i);
            dpmtName = person.getDepartment();
            dpmtNum = departmentLengths.get(dpmtName);
            //获得这个sheet的第i + 3行
            row = sheet1.createRow(i + 3);
            //设置行长度自动
            //row.setHeight((short)500);
            row.setHeightInPoints(20);
            //row.setZeroHeight(true);

            for(int j = 0;j < 35; j ++){
                //设置每个sheet每一行的宽度,自动,根据需求自行确定
                sheet1.autoSizeColumn(j + 1, true);
                //获得这一行的每j列
                cell = row.createCell(j);

                cell.setCellStyle(cellStyle);

                //给单元格设值
                if (lastCellIndex == i + 3 & j == 0) {
                    //画出侧边部门
                    int nextIndex = lastCellIndex + dpmtNum - 1;
                    //新建一个合并的单元格对象
                    CellRangeAddress departmentRangeCell = new CellRangeAddress(lastCellIndex, nextIndex, 0, 0);
                    //将新合并的单元格置入表中
                    sheet1.addMergedRegion(departmentRangeCell);
                    //取得第一行 departmentRow
                    //取得该行的第一列 departmentCell
                    //为该列 departmentCell 赋值
                    CellStyle cellStyle1 = wb.createCellStyle();
                    cellStyle1.cloneStyleFrom(cellStyle);
                    cellStyle1.setWrapText(true);
                    cell.setCellStyle(cellStyle1);
                    cell.setCellValue(dpmtName);
                    //更新下一个要合并的单元格的第一行
                    lastCellIndex = ++ nextIndex;
                }else if(j == 1){
                    cell.setCellValue(person.getuName());
                }else if(j==2){
                    cell.setCellValue(person.getPost());
                }else if(j==3){
                    cell.setCellValue(person.getuNo());
                }else{
                    cell.setCellValue("");
                }
            }
        }

        File file = new File("d://model.xls");
        String filePath = file.getPath();
        //输出
        OutputStream os = new FileOutputStream(file);
        wb.write(os);
        os.close();
        return  filePath;
    }

    /**
     * 边框
     * @param wb
     * @return
     */
    public static CellStyle createStyleCell(Workbook wb){
        CellStyle cellStyle = wb.createCellStyle();
        //设置一个单元格边框颜色
        cellStyle.setBorderBottom(CellStyle.BORDER_THIN);
        cellStyle.setBorderTop(CellStyle.BORDER_THIN);
        cellStyle.setBorderLeft(CellStyle.BORDER_THIN);
        cellStyle.setBorderRight(CellStyle.BORDER_THIN);
        //设置一个单元格边框颜色
        cellStyle.setRightBorderColor(IndexedColors.BLACK.getIndex());
        cellStyle.setLeftBorderColor(IndexedColors.BLACK.getIndex());
        cellStyle.setBottomBorderColor(IndexedColors.BLACK.getIndex());
        cellStyle.setTopBorderColor(IndexedColors.BLACK.getIndex());
        return cellStyle;
    }
    /**
     * 设置文字在单元格里面的位置
     * CellStyle.ALIGN_CENTER
     * CellStyle.VERTICAL_CENTER
     * @param cellStyle
     * @return
     */
    public static CellStyle setCellStyleAlignment(CellStyle cellStyle){
        //设置上下
        cellStyle.setAlignment(CellStyle.ALIGN_CENTER);
        //设置左右
        cellStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
        return cellStyle;
    }
    /**
     * 格式化单元格
     * 如#,##0.00,m/d/yy去HSSFDataFormat或XSSFDataFormat里面找
     * @param cellStyle
     * @param fmt
     * @return
     */
    public static CellStyle setCellFormat(CreationHelper helper, CellStyle cellStyle, String fmt){
        //还可以用其它方法创建format
        cellStyle.setDataFormat(helper.createDataFormat().getFormat(fmt));
        return cellStyle;
    }
    /**
     * 前景和背景填充的着色
     * @param cellStyle
     * @param bg IndexedColors.ORANGE.getIndex();
     * @param fg IndexedColors.ORANGE.getIndex();
     * @param fp CellStyle.SOLID_FOREGROUND
     * @return
     */
    public static CellStyle setFillBackgroundColors(CellStyle cellStyle, short bg, short fg, short fp){
        //cellStyle.setFillBackgroundColor(bg);
        cellStyle.setFillForegroundColor(fg);
        cellStyle.setFillPattern(fp);
        return cellStyle;
    }
    /**
     * 设置字体
     * @param wb
     * @return
     */
    public static Font createFonts(Workbook wb){
        //创建Font对象
        Font font = wb.createFont();
        //设置字体
//        font.setFontName("黑体");
        //着色
//        font.setColor(HSSFColor.BLUE.index);
        //斜体
//        font.setItalic(true);
        //字体大小
        font.setFontHeight((short)300);
        return font;
    }
}
