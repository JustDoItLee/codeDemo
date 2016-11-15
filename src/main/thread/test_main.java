package main.thread;

/**
 * @author 李智
 * @date 2016/11/6
 *
 * test
 */
public class test_main {
    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            test_1 test_1 = new test_1();
            Thread t1 = new Thread(test_1);
            t1.start();
            System.out.println("end!");
        }
    }
}
