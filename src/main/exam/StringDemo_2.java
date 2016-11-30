package main.exam;

import java.lang.reflect.Field;

/**
 * @author 李智
 * @date 2016/11/30
 */
public class StringDemo_2 {
        public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
            String s1 = "java";
            String s2 = s1;
            String s3 = "java";
            String s4 = "java".toString();//toString是return this
            Field field1 = s1.getClass().getDeclaredField("value");

            Field field2 = s2.getClass().getDeclaredField("value");
            Field field3 = "java".getClass().getDeclaredField("value");
            Field field4 = s4.getClass().getDeclaredField("value");
            field1.setAccessible(true);
            field2.setAccessible(true);
            field3.setAccessible(true);
            field4.setAccessible(true);
            char cs1[] = (char[]) (char[]) field1.get(s1);
            char cs2[] = (char[]) (char[]) field2.get(s2);
            char cs3[] = (char[]) (char[]) field3.get("java");
            char cs4[] = (char[]) (char[]) field4.get("java");
            cs1[0] = 'Z';
            cs2[1] = 'Z';
            cs3[2] = 'Z';
            cs4[3] = 'Z';
            System.out.println(s1);
            System.out.println((new StringBuilder()).append("s1:").append(s1).toString());
            System.out.println(s2);
            System.out.println((new StringBuilder()).append("s2:").append(s2).toString());
            System.out.println("java");
//            System.out.println("s3:java");
            System.out.println((new StringBuilder()).append("s3:").append(s3).toString());
            System.out.println(s4);
            System.out.println((new StringBuilder()).append("s4:").append(s4).toString());
        }
}
