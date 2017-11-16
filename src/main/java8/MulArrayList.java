import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author 李智
 * @date 2017/11/2
 */
public class MulArrayList implements Runnable{
    private static List<String> TEST_LIST = new ArrayList<String>();
    static {
        TEST_LIST.add("A");
        TEST_LIST.add("B");
        TEST_LIST.add("C");

    }
    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(50);
        for (int i = 0; i < 50; i++) {
            Runnable worker = new MulArrayList();
            executor.execute(worker);
        }
        executor.shutdown();
    }


    @Override
    public void run() {
        for (String s : TEST_LIST){
            System.out.println(s);
        }
    }
}
