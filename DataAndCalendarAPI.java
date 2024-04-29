import java.time.DayOfWeek;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.OffsetDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;
import java.util.Locale;
import java.util.Set;

public class DataAndCalendarAPI {
    public static void main(String[] args) {
        LocalDateTime localDateTime = LocalDateTime.now();
        // In ISO format yyyy-MM-dd
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);
        // define localdata with of method
        LocalDate localDate1 = LocalDate.of(2024, 04, 30);
        System.out.println(localDate1);
        // define local date with parse method
        LocalDate localDate2 = LocalDate.parse("2024-09-30");
        System.out.println(localDate2);
        LocalTime localTime = LocalTime.now();
        LocalDateTime specificLocalDateTime = LocalDateTime.of(2002, Month.JUNE, 28, 12, 36, 30);
        LocalDateTime specificLocalDateTimeInFuture = LocalDateTime.of(2030, Month.JUNE, 28, 00, 00, 00);
        ZonedDateTime zonedDateTimeInd = ZonedDateTime.now(ZoneId.of("Asia/Kolkata"));
        ZonedDateTime zonedDateTimeUS = ZonedDateTime.now(ZoneId.of("America/New_York"));
        LocalDate nextMonth = LocalDate.of(2024, Month.JUNE, 30);
        LocalTime nextHour = LocalTime.of(16, 45);
        Instant instant = Instant.now();
        System.out.println(localDateTime);
        System.out.println(localDate);
        System.out.println(localTime);
        System.out.println(specificLocalDateTime);
        System.out.println(specificLocalDateTimeInFuture);
        System.out.println(zonedDateTimeInd);
        System.out.println(zonedDateTimeUS);
        System.out.println(Duration.between(zonedDateTimeInd, zonedDateTimeUS));
        System.out.println(Duration.between(zonedDateTimeUS, zonedDateTimeInd));
        System.out.println(Period.between(localDate, nextMonth));
        System.out.println(Duration.between(localTime, nextHour));
        System.out.println(instant);
        Set<String> availableZoneIds = ZoneId.getAvailableZoneIds();
        System.out.println(availableZoneIds.size());


        LocalDate tomorrow = LocalDate.now().plusDays(1);
        LocalDate previousMonthSameDay = tomorrow.minus(1, ChronoUnit.MONTHS);
        System.out.println(tomorrow);
        System.out.println(previousMonthSameDay);

        DayOfWeek monday = LocalDate.parse("2024-04-29").getDayOfWeek();
        int twelve = LocalDate.parse("2024-04-29").getDayOfMonth();
        System.out.println(twelve);
        System.out.println(monday);

        boolean leapYear = LocalDate.now().isLeapYear();
        System.out.println(leapYear);
        // also have .isBefore() and .isAfter for localDate


        // LocalTime
        LocalTime localTime2 = LocalTime.of(4, 40);
        LocalTime localTime4 = localTime2.plus(1, ChronoUnit.HOURS);
        System.out.println(localTime2+"\n"+localTime4);
        System.out.println(LocalTime.now().getHour());
        // also have isBefore method
        LocalTime maxTime = LocalTime.MAX;
        LocalTime minTime = LocalTime.MIN;
        LocalTime noonTime = LocalTime.NOON;
        LocalTime midNigthTime = LocalTime.MIDNIGHT;
        System.out.println(maxTime+"\n"+minTime+"\n"+noonTime+"\n"+midNigthTime);


        // LocalDateTime
        LocalDateTime localDateTime2 = LocalDateTime.now();
        System.out.println(localDateTime2);
        LocalDateTime localDateTime3 = LocalDateTime.of(2024, Month.APRIL, 20, 06, 40);
        System.out.println(localDateTime3);
        LocalDateTime localDateTime4 = LocalDateTime.parse("2034-04-29T06:33:36");
        System.out.println(localDateTime4);
        System.out.println(localDateTime2.plusDays(1));
        System.out.println(localDateTime2.minusHours(4));
        System.out.println(localDateTime4.getMonth());

        // ZonedDateTime
        ZoneId zoneId = ZoneId.of("Asia/Kolkata");
        System.out.println(zoneId);
        ZonedDateTime zonedDateTime1 = ZonedDateTime.of(localDateTime, ZoneId.of("America/New_York"));
        System.out.println(zonedDateTime1);
        ZonedDateTime zonnDateTime2 = ZonedDateTime.parse("2024-05-03T16:25:34+01:00[Europe/Paris]");
        System.out.println(zonnDateTime2);


        // Zone offsets
        LocalDateTime localDateTime5 = LocalDateTime.now();
        ZoneOffset offset = ZoneOffset.of("+05:30");
        OffsetDateTime offsetDateTime = OffsetDateTime.of(localDateTime5, offset);
        System.out.println(offsetDateTime);
        System.out.println(Duration.between(localDateTime5, offsetDateTime));
        

        // Period
        LocalDate finalDate = localDate.plus(Period.ofDays(5));
        int five = Period.between(localDate, finalDate).getDays();
        System.out.println(five);
        long five1 = ChronoUnit.DAYS.between(localDate, finalDate);
        System.out.println(five1);

        // Duration 
        LocalTime finalTime = localTime.plus(Duration.ofMinutes(20));
        System.out.println(Duration.between(localTime, finalTime).getSeconds());
        System.out.println(ChronoUnit.MINUTES.between(localTime, finalTime));

        // Compatibility with date and calendar 
        // ofInstant() method to convert existing Date and calender to new Date and Time API

        // LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
        // LocalDateTime.ofInstant(calendar.toInstant(), ZonedId.systemDefault());

        LocalDateTime localDateTime6 = LocalDateTime.of(2024, Month.JANUARY, 29, 01, 30);
        String localDateString = localDateTime6.format(DateTimeFormatter.ISO_DATE);
        System.out.println(localDateString);
        System.out.println(localDateTime6.format(DateTimeFormatter.ofPattern("yyyy/MM/dd")));
        // System.out.println(localDateTime6.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM).withLocale(Locale.US)));
        
    }
}
