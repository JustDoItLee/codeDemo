package main.thread;

/**
 * @author 李智
 * @date 2016/11/6
 *
 * 线程测试
 */
public class Test_1 implements Runnable{
    public Test_1(){
        System.out.println("start!");
    }
    public void run() {
        System.out.println("Threading~");
        Thread.yield();
    }
}
