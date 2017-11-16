import java.util.Arrays;
import java.util.Scanner;

/**
 * @author 李智
 * @date 2017/11/3
 */
public class JollyJumper02 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            //输入多少个
            int cases = sc.nextInt();

            if(cases>3000){
                break;
            }
            //输入数组
            int arr[] = new int[cases];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = sc.nextInt();
            }

            boolean flag = true;
            if (cases != 1) {

                //取相邻数字相减的值，并取绝对值
                int arrD[] = new int[cases - 1];
                for (int i = 0; i < arr.length - 1; i++) {
                    arrD[i] = Math.abs(arr[i] - arr[i + 1]);
                }

                //排序
                Arrays.sort(arrD);

                //检查1~(n-1)的值
                for (int i = 0; i < arrD.length; i++) {
                    if (arrD[i] != i + 1) {
                        flag = false;
                        break;
                    }
                }
            }

            //结果输出
            if (flag) System.out.println("Jolly");
            else System.out.println("Not jolly");
        }
    }
}
