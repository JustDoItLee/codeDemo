package main.exam;

import java.lang.reflect.Field;

/**
 * @author 李智
 * @date 2016/11/25
 *
 * final修饰的变量，引用不变，引用对象的内容可变
 */
public class StringDemo {
    public static void main(String[] args) {
        String s = "abcd";
        final String b = "abcd";
        final String s1 = s;
        System.out.println("修改前:s1 = " + s1);
        System.out.println("修改前:b = " + b);
        System.out.println("修改前:s = " + s); //修改前
        try {
            Field field = s.getClass().getDeclaredField("value");
            field.setAccessible(true);
            char[] cs = (char[]) field.get(s);
            cs[2] = 'Z';
            System.out.println("--------");
            System.out.println(s);
            System.out.println(b);
            System.out.println(s1);
            System.out.println("--------");
            System.out.println("s: " + s);
            System.out.println("b: " + b);
            System.out.println("s1: " + s1);
            System.out.println("--------");
            System.out.println(s);
            System.out.println(b);
            System.out.println(s1);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}