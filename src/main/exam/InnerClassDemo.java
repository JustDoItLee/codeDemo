/**
 * @author 李智
 * @date 2017/8/8
 */
public class InnerClassDemo {
    public static void main(String[] args) {
        User user = new User();
//        user.toString();
        System.out.println(user.getString());
        user = new User() {
            public String getString() {
                return "this is String";
            }
        };
        System.out.println(user.getString());
    }

}
