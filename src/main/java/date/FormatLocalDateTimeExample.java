package date;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class FormatLocalDateTimeExample {

    public static void main(String[] args) {
        parseTime();
        parseLocalDateTimeFromString();
        parseLocalDateTimeToString();
    }

    private static void parseLocalDateTimeToString() {
        String date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy' 'HH:mm"));
        System.out.println(date);
    }

    private static void parseLocalDateTimeFromString() {
        String date = "2020-05-30 14:23";
        LocalDateTime localDateTime = LocalDateTime.parse(date,
                DateTimeFormatter.ofPattern("yyyy-MM-dd' 'HH:mm"));
        System.out.println(localDateTime);

        String date1 = "30/10/2020 19:00:32";
        LocalDateTime localDateTime1 = LocalDateTime.parse(date1,
                DateTimeFormatter.ofPattern("dd/MM/yyyy' 'HH:mm:ss"));
        System.out.println(localDateTime1);
    }

    private static void parseTime() {
        String time = "16:00";
        LocalTime localTime = LocalTime.parse(time);
        LocalTime localTime1 = LocalTime.parse(time, DateTimeFormatter.ISO_LOCAL_TIME);
        System.out.println(localTime + " is the same of " + localTime1);

    }
}
