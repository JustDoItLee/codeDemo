package main.exam;

/**
 * @author 李智
 * @date 2017/2/6
 */
public class Test01 {
    public static void main(String[] args) {
        int a = 10;
        int b = 20;
        /* 调用方法1*/
        method1(a, b); //要求在方法1被调用之后打印出a=100 b=200 请写出method1的代码
        System.out.println("a=" + a);
        System.out.println("b=" + b);
    }

    private static void method1(Integer a, Integer b) {
        a = 100;
        b = 200;
    }

}
