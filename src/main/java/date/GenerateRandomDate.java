package date;

import java.time.LocalDate;
import java.util.concurrent.ThreadLocalRandom;

public class GenerateRandomDate {

    public static LocalDate generateBoundedDate() {
        LocalDate today = LocalDate.now();
        LocalDate aYearAhead = today.plusYears(1);

        long randomDate = ThreadLocalRandom.current()
                .nextLong(today.toEpochDay(), aYearAhead.toEpochDay());

        return LocalDate.ofEpochDay(randomDate);
    }

    public static LocalDate generateUnboundedDate() {
        LocalDate today = LocalDate.now();
        long hundredYears = 100 * 365;

        long randomDate = ThreadLocalRandom.current()
                .nextLong(today.toEpochDay(), hundredYears);

        return LocalDate.ofEpochDay(randomDate);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            //System.out.println(generateBoundedDate());
        }

        for (int i = 0; i < 10; i++) {
            System.out.println(generateUnboundedDate());
        }
    }
}
