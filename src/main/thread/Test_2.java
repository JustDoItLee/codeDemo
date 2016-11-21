package main.thread;

/**
 * @author 李智
 * @date 2016/11/6
 *
 * 输出测试
 */
public class Test_2 {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
        for (int i = 0; i < 10; i++) {
            new Thread("" + i) {
                public void run() {
                    System.out.println("Thread: " + getName() + " running");
                }
            }.start();
        }
    }
}