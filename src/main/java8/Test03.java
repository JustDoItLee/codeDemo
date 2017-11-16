import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 李智
 * @date 2017/10/30
 */
public class Test03 {
    final int i = 3;

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        for (String s : list) {

        }
        Iterator t = list.iterator();
        while (t.hasNext()){

        }
    }

    class Asd {
        public void getI() {
            System.out.println(i);
        }
    }

    static class Bsd {
        public void getI() {
            Test03 t = new Test03();
            System.out.println(t.i);
        }
    }
}
