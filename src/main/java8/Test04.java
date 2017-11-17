/**
 * @author 李智
 * @date 2017/11/16
 */
public class Test04 {
    static int b = 0;
    public static void main(String[] args) {
//        Test05 obj = null;
//        System.out.println(obj.foo());
        Integer i = 0 ;
        i += i > 0 ? i++ : i--;
        f(10);
        System.out.println(b);
    }
    public static int f(int x) {
        b++;
        if (x <= 2)
            return 1;
        return f(x - 2) + f(x - 4) + 1;
    }
}

class Test05 {
    public static String foo() {
        System.out.println("foo called");
        return "return called";
    }
}