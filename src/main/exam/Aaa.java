package main.exam;

/**
 * @author 李智
 * @date 2017/2/10
 */
class Aaa {
    Aaa() {
        System.out.println("0000");
    }

    Aaa(String str) {
        this();
        System.out.println(str);
    }

    Aaa(String str, String str2) {
        this(str);
        System.out.println(str2);
    }

    public static void main(String[] args) {
        Aaa a = new Aaa();
        System.out.println("---------");
        Aaa b = new Aaa("jack");
        System.out.println("---------");
        Aaa c = new Aaa("jack","rose");
    }
}