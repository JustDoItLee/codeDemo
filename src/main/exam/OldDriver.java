package main.exam;

/**
 * @author 李智
 * @date 2017/2/18
 */
public class OldDriver {
    public static void main(String[] args) {
        java.util.Scanner input = new java.util.Scanner(System.in);
        System.out.println("黑车司机虚假磁力链接发车器");
        System.out.print("输入需要发的黑车数量：");
        int ljs = input.nextInt();
        for (int i = 1; i <= ljs; i++) {
            System.out.println("magnet:?xt=urn:btih:" + CLSC());
/*调用 CLSC 函数，获取 40 个随机生成的字符串（CLSC指 磁力生成）*/
        }
    }

    public static String CLSC() {
        String cllj = "";
        String randomchar;
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        for (int i = 0; i < 40; i++) {
            int RandomNumber = (int) (Math.random() * 35);
/*随机生成一个范围在 [0,35] 的数字*/
            randomchar = "" + chars.charAt(RandomNumber);
/*随机选择一个字符，字符位置由上一步随机数字决定*/
            cllj = cllj + randomchar;
/*将随机字符附到 cllj 字符串上，重复 40 次*/
        }
        return cllj;
    }
}
