package core.utils;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

public class DateFormat {

    public static String getDateFormatNow() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
    }

    public static String getHourFormatNowHours() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("h a"));
    }

    public static String getTimeZone() {
        return ZoneOffset.systemDefault().getId();
    }
}
