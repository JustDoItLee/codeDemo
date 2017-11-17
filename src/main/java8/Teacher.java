/**
 * @author 李智
 * @date 2017/11/17
 */
public class Teacher extends Person {
    public String subject = "";
    private String name = "";

    public Teacher(String _name, int _age) {
        super(_name, _age);
    }

    public void getDescription() {
        System.out.println("My name is " +
                name + ". I’m " + age +
                " years old. I’m a Teacher. I teach " +
                subject + ".");
    }

    public static void main(String[] args) {
        Teacher teacher = new Teacher("Mary", 23);
        teacher.subject = "English";
        teacher.age -= 3;

        teacher.getDescription();
    }
}