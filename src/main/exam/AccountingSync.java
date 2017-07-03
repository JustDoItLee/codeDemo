import jdk.nashorn.internal.runtime.regexp.joni.exception.InternalException;

/**
 * @author 李智
 * @date 2017/7/3
 */
public class AccountingSync implements Runnable {
    static int i = 0;

    public void run() {
        for (int j = 0; j < 10000000; j++) {
            increase();
        }
    }

    private synchronized void increase() {
        i++;
    }

    public static void main(String[] args) throws InterruptedException {
        AccountingSync as = new AccountingSync();
        Thread t1 = new Thread(as);
        Thread t2 = new Thread(as);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(i);
    }
}
