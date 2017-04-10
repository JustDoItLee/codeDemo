package main.exam;


/**
 * @author 李智
 * @date 2017/4/10
 */
public class TestStatic {
    static {
        System.out.println("我执行了。");
    }

    public static void main(String[] args) throws Exception {
        ClassLoader loader = TestStatic2.class.getClassLoader();
        Class cls = loader.loadClass("main.exam.TestStatic2");
        TestStatic2 t2 = (TestStatic2) cls.newInstance();

        ClassLoader loader1 = TestStatic.class.getClassLoader();
        Class cls1 = loader1.loadClass("main.exam.TestStatic");
        TestStatic t1 = (TestStatic) cls1.newInstance();
        t1.print();


    }

    public void print() {
        System.out.println("创建对象了。");
    }
}

class TestStatic2 {
    static {
        System.out.println("我应该先执行");
    }
}
