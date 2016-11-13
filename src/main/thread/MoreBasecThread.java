package main.thread;

/**
 * @author 李智
 * @date 2016/11/6
 */
public class MoreBasecThread {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new Thread(new LiftOff()).start();
            System.out.println("waiting !");
        }
    }
}
