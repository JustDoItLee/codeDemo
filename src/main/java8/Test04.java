/**
 * @author 李智
 * @date 2017/11/16
 */
public class Test04 {
    public static void main(String[] args) {
        Test05 obj = null;
        System.out.println(obj.foo());
    }
}

class Test05 {
    public static String foo() {
        System.out.println("foo called");
        return "return called";
    }
}