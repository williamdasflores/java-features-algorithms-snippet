package date;

import java.time.Duration;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class DurantionExamples {

    public static void main(String[] args) {
        LocalTime localTime1 = LocalTime.now();
        LocalTime localTime2 = LocalTime.of(23,30);
        long diff = localTime1.until(localTime2, ChronoUnit.MINUTES);
        System.out.println("diff: " + diff);

        Duration between = Duration.between(localTime1, localTime2);
        System.out.println("toMinutos: " + between.toMinutes());

        Duration duration = Duration.ofDays(1);
        System.out.println("duration hours: " + duration.toHours());
    }
}
