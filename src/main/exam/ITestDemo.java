/**
 * @author 李智
 * @date 2017/7/14
 */
public class ITestDemo {
    public static void main(String[] args) {
        int i = 0;
        int j = 0;
        i = i++ + ++i;
        j = ++j + j++;

        System.out.println(i);
        System.out.println(j);
    }
}
