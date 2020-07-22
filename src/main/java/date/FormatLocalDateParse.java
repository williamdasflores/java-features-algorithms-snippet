package date;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class FormatLocalDateParse {

    public static void main(String[] args) {
        String date = "2020-07-21";
        LocalDate localDate = LocalDate.parse(date);
        LocalDate localDate1 = LocalDate.parse(date, DateTimeFormatter.ISO_LOCAL_DATE);
        System.out.println(localDate + " is the same of " + localDate1);

        String date1 = "20200720";
        LocalDate localDate2 = LocalDate.parse(date1, DateTimeFormatter.BASIC_ISO_DATE);
        System.out.println(localDate);

        //Custom dateformat
        String date2 = "21/07/2020";
        LocalDate localDate3 = LocalDate.parse(date2, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        System.out.println(localDate3);
    }
}
