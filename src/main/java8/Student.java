/**
 * @author 李智
 * @date 2017/11/2
 */
public class Student {
    private int age;
    private boolean sex;
    private int weight;

    public Student(int age, boolean sex, int weight) {
        this.age = age;
        this.sex = sex;
        this.weight = weight;
    }

    public int getAge() {
        return age;
    }

    public boolean isSex() {
        return sex;
    }

    public int getWeight() {
        return weight;
    }
}
