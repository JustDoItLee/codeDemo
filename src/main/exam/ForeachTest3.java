package main.exam;

import java.util.LinkedList;
import java.util.List;

/**
 * @author 李智
 * @date 2016/12/29
 */
public class ForeachTest3 {
    public static void main(String[] args) {
        List<String> tempList = new LinkedList<String>();
        tempList.add("A");
        tempList.add("B");
        tempList.add("C");

        for (int i = 0; i < tempList.size(); i++) {
            tempList.remove(i);
        }

        if (tempList.size() > 0) {
            System.out.println("剩余的个数为：" + tempList.size() + ",具体的元素为：");

            for (String t : tempList) {
                System.out.println(t);
            }
        } else {
            System.out.println("所有的元素已经删除完毕");
        }
    }
}
