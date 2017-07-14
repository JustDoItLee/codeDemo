import java.util.ArrayList;

/**
 * @author 李智
 * @date 2017/7/14
 */
public class ArrayListDemo {
    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList(100);
        String s = null;
        arrayList.add(s);
        arrayList.add(null);
//        arrayList.add(98, s);
//        arrayList.add(101, s);
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println(arrayList.get(i));
        }
    }
}
