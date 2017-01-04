package main.exam;

/**
 * @author 李智
 * @date 2017/1/4
 */
public class instanceofExam {
    public static void main(String args[]) {
        if ("abc" instanceof String) {
            System.out.println(" Yes ,送分题！！！");
        }
        Object helloc = (Object) "1234";
        if (helloc instanceof instanceofExam) {
            System.out.println("No!!!");
        }
    }

}