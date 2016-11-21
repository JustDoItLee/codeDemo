package main.exam;

/**
 * @author 李智
 * @date 2016/11/17
 *
 * 关于String小测试
 */
public class StringTest {
    public static void main(String[] args) {
        String s1 = new String("xyz");
        String s2 = s1.intern();

        System.out.println(s1 == s1.intern());
        System.out.println(s1 + " " + s2);
        System.out.println(s2 == s1.intern());
    }
}
