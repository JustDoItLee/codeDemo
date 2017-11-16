import java.util.Scanner;

/**
 * @author 李智
 * @date 2017/11/16
 */
public class ClassMain {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            String str = scan.nextLine();
            System.out.println(getResult(str));
        }
    }

    public static String getResult(String str) {
        return str.replaceAll("[A-Z]", "") + str.replaceAll("[a-z]", "");
    }
}
