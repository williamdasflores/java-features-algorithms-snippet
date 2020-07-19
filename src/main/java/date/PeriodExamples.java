package date;

import java.time.LocalDate;
import java.time.Period;

public class PeriodExamples {

    public static void main(String[] args) {
        LocalDate date1 = LocalDate.now();
        LocalDate date2 = LocalDate.of(2020, 12, 30);
        Period period = date1.until(date2);
        System.out.println("Days: " + period.getDays());
        System.out.println("Months: " + period.getMonths());
        System.out.println("Years: " + period.getYears());

        Period between = Period.between(date1, date2);
        System.out.println(between.getDays());

    }
}
