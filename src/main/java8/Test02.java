/**
 * @author 李智
 * @date 2017/10/27
 */
public class Test02 {
    public static void main(String[] args) {
       C c = new C();
        System.out.println(c.i);

    }

    public void test(A a){
        a.sout();
    }

}

interface A {
    public void sout();
}

class B implements A {
    protected int i = 5;
    @Override
    public void sout() {
        System.out.println("BBB");
    }


}

class C extends B {
    @Override
    public void sout() {
        System.out.println("CCC");
    }
}