package main.thread;

/**
 * @author 李智
 * @date 2016/11/6
 */
public class test_1 implements Runnable{
    public  test_1(){
        System.out.println("start!");
    }
    public void run() {
        System.out.println("Threading~");
        Thread.yield();
    }
}
