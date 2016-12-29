package main.exam;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 李智
 * @date 2016/12/29
 */
public class ForeachTest {
    public static void main(String[] args) {
        List<String> a = new ArrayList<String>();
        a.add("1");
        a.add("2");
        for (String temp : a) {
            //"1"是正常，"2"将报java.util.ConcurrentModificationException
            if ("1".equals(temp)) {
                a.remove(temp);
            }
        }
        System.out.println(a);
    }
}
