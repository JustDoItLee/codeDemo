package main.exam;

import java.util.Arrays;
import java.util.List;

/**
 * @author 李智
 * @date 2016/12/29
 */
public class AsListTest {
    public static void main(String[] args) {
        String[] strings = new String[]{"jack","tom"};
        List list = Arrays.asList(strings);
        System.out.println(list);

        strings[0] = "fuck";
        System.out.println(list);

    }
}
