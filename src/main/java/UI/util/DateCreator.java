package UI.util;

import java.time.DateTimeException;
import java.time.LocalDate;

public final class DateCreator {
    private final static int DEFAULT_YEAR = 2099;
    private final static int DEFAULT_MOUNT = 1;
    private final static int DEFAULT_DAY = 1;

    private DateCreator() {  }

    public static LocalDate createDate(int year, int mount, int day) {
        LocalDate date = null;
        try {
            date = LocalDate.of(year, mount, day);
        } catch (DateTimeException e) {
            date = LocalDate.of(DEFAULT_YEAR, DEFAULT_MOUNT, DEFAULT_DAY);
        } finally {
            return date;
        }
    }
}
