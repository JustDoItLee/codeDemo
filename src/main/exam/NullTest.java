package main.exam;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 李智
 * @date 2016/11/21
 */
public class NullTest {

    public static void main(String[] args) {
        List<String> fenxiaoCommissions = null;
//        List<String> fenxiaoCommissions = new ArrayList<String>();
        for (String commission : fenxiaoCommissions) {
            System.out.println(1);
        }
    }
}
