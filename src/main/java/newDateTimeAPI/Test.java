package newDateTimeAPI;

import java.time.LocalDate;

/**
 * Created by jason-geng on 1/27/17.
 */
public class Test {

    public static void main(String[] args) {
        LocalDate date = LocalDate.of(2017, 1, 1);
        System.out.println(date.toString());
        date = date.with(new NextWorkingDay());
        System.out.println(date.toString());

    }
}
