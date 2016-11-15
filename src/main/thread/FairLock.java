package main.thread;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 李智
 * @date 2016/11/15
 */
public class FairLock {
    private boolean isLocked = false;  //是否加锁的信号
    private Thread lockingThread = null;   //加锁的线程
    private List<QueueObject> waitingThreads =
            new ArrayList<QueueObject>();   //信号量队列

    public void lock() throws InterruptedException {  //多个线程可同时进入
        QueueObject queueObject = new QueueObject();  //局部对象，线程安全
        boolean isLockedForThisThread = true;  //是否为当前线程加锁
        synchronized (this) {  //将当前线程（用信号量）推入队列
            waitingThreads.add(queueObject);
        }

        while (isLockedForThisThread) {
            synchronized (this) {  //加锁操作需要同步
                //锁状态依然被检查和设置，以避免出现滑漏条件
                isLockedForThisThread = isLocked || waitingThreads.get(0) != queueObject;
                if (!isLockedForThisThread) { //如果对象未加锁且队列头部是当前线程
                    isLocked = true; //加锁
                    waitingThreads.remove(queueObject); //从队列中移除当前线程
                    lockingThread = Thread.currentThread();
                    return;
                }
            }
            try { //放在同步块之外，避免monitor嵌套锁死
                queueObject.doWait(); //监视器对象（持有信号量isNotified）等待
            } catch (InterruptedException e) {
                synchronized (this) {
                    waitingThreads.remove(queueObject);
                }
                throw e;
            }
        }
    }

    public synchronized void unlock() {
        if (this.lockingThread != Thread.currentThread()) { //加锁的不是当前线程
            throw new IllegalMonitorStateException("Calling thread has not locked this lock");
        }
        isLocked = false; //解锁
        lockingThread = null;
        if (waitingThreads.size() > 0) { //唤醒第一个线程
            waitingThreads.get(0).doNotify();
        }
    }
}