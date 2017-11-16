import java.lang.reflect.Field;

/**
 * @author 李智
 * @date 2017/11/16
 */
public class SwapTest {
    public static void main(String[] args) {
        Integer a = 1;
        Integer b = 2;
        System.out.println(a + " " + b);
        swap(a, b);
        System.out.println(a + " " + b);
    }

    public static void swap(Integer a, Integer b) {
        if (a == null || b == null) {
            return;
        }

        Class<Integer> integerClass = (Class<Integer>) a.getClass();
        try {
            Field value = integerClass.getDeclaredField("value");
            value.setAccessible(true);
            int temp = a;
            value.setInt(a, b);
            value.setInt(b, temp);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
