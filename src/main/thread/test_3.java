package main.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author 李智
 * @date 2016/11/13
 *
 * 生产消费者
 */
class Resourse {
    private String name;
    private int count = 1;
    private boolean flag = false;

    public synchronized void set(String name) {
        while (flag)
            try {
                this.wait();
            } catch (InterruptedException e) {
                // TODO: handle exception
            }
        this.name = name + "--" + count++;
        System.out.println(Thread.currentThread().getName() + "...生产者.." + this.name);
        flag = true;
        notifyAll();
    }

    public synchronized void out() {
        Lock lock = new ReentrantLock();
        while (!flag)
            try {
                wait();
            } catch (InterruptedException e) {
                // TODO: handle exception
            }
        System.out.println(Thread.currentThread().getName() + "...消费者........." + this.name);
        flag = false;
        this.notifyAll();
    }
}

class Product implements Runnable {
    private Resourse r;

    public Product(Resourse r) {
        // TODO Auto-generated constructor stub
        this.r = r;
    }

    public void run() {
        while (true) {
            r.set("烤鸭");

        }

    }

}

class Consumer implements Runnable {
    private Resourse r;

    public Consumer(Resourse r) {
        this.r = r;
    }

    public void run() {
        while (true) {
            r.out();
        }
    }
}

public class test_3 {
    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Resourse r = new Resourse();
        Product pro = new Product(r);
        Consumer con = new Consumer(r);
        Thread t1 = new Thread(pro);
        Thread t2 = new Thread(pro);
        Thread t3 = new Thread(con);
        Thread t4 = new Thread(con);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }

}
