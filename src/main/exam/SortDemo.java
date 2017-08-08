/**
 * @author 李智
 * @date 2017/7/17
 */
public class SortDemo {
    public static void main(String[] args) {
        int[] prel = new int[]{2, 4, 9, 5, 3, 6, 7, 8, 11, 1, 12, 0, 10};
        int[] endl = orderBysel(prel);
        for (int i : endl) {
            System.out.print(i + "<");
        }
    }

    private static int[] orderBysel(int[] in) {
        int[] inl = new int[in.length];
        for (int i = 0; i < in.length; i++) {
            inl[in[i]] = in[i];
        }
        return inl;
    }


}
