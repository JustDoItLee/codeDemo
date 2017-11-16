/**
 * @author 李智
 * @date 2017/9/19
 */
public class Test {
    public static int k = 0;
    public static Test t1 = new Test("t1");
    public static Test t2 = new Test("t2");
    public static int i = print("i");
    public static int n = 99;
    private int a = 0;
    public int j = print("j");

    {
        print("构造块");
    }

    static {
        print("静态块");
    }

    public Test(String str) {
        System.out.println((++k) + ":" + str + " i=" + i + " n=" + n);
        ++i;
        ++n;
    }

    public static int print(String str) {
        System.out.println((++k) + ":" + str + " i=" + i + " n=" + n);
        ++n;
        return ++i;
    }

    public static void main(String[] args) {
        for (int i = 1; i < 10; i++) {
            for (int j = 1; j < i + 1; j++) {
                int m = i * j;
                System.out.printf("%s x %s = %-5s", j, i, m);
            }
            System.out.println();
        }
    }
}
