package main.exam;

/**
 * @author 李智
 * @date 2017/2/16
 */
public class WeekDay {

    private WeekDay() {
    }


    public final static WeekDay SUN = new WeekDay();
    public final static WeekDay MON = new WeekDay();

    public WeekDay nextDay() {
        if (this == SUN) {
            return MON;
        } else {
            return SUN;
        }
    }

    public String toString() {
        return this == SUN ?"SUN" :"MON";
    }
}