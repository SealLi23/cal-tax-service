package com.secretservice.taxservice.utils;

import java.util.Calendar;
import java.util.Date;

public class DateUtils {
    private static Calendar cal = Calendar.getInstance();
    public static boolean isWeekend(final Date date) {
        cal.setTime(date);
        int day = cal.get(Calendar.DAY_OF_WEEK);
        return day == Calendar.SATURDAY || day == Calendar.SUNDAY;
    }
    public static boolean checkSameDate(final Date date1, final Date date2) {
        return getMonth(date1) == DateUtils.getMonth(date2)
                && DateUtils.getDate(date1) == DateUtils.getDate(date2);
    }

    /**
     * Check whether a date is a toll-free based on the certain rule in Gothenburg
     * Ref: https://www.calendarlabs.com/holidays/sweden/2013
     * @param date The date to check
     * @return True, if it is a toll-free date, or false as the date is not.
     */
    public static boolean isPublicHoliday(final Date date) {
        cal.setTime(date);
        int month = cal.get(Calendar.MONTH);
        int dayOfMonth = cal.get(Calendar.DAY_OF_MONTH);
        if (    (month == 1 && (dayOfMonth == 1 || dayOfMonth == 5 || dayOfMonth == 6) ||
                (month == 3 && (dayOfMonth == 28 || dayOfMonth == 29 || dayOfMonth == 30 || dayOfMonth == 31)) ||
                (month == 4 && (dayOfMonth == 1 || dayOfMonth == 30)) ||
                (month == 5 && (dayOfMonth == 1 || dayOfMonth == 8 || dayOfMonth == 9 || dayOfMonth == 18 || dayOfMonth == 19 || dayOfMonth == 20)) ||
                (month == 6 && (dayOfMonth == 5 || dayOfMonth == 6 || dayOfMonth == 21 || dayOfMonth == 22)) ||
                (month == 7) ||
                (month == 10 && dayOfMonth == 31)||
                (month == 11 && dayOfMonth == 1) ||
                (month == 12 && (dayOfMonth == 24 || dayOfMonth == 25 || dayOfMonth == 26 || dayOfMonth == 30 || dayOfMonth == 31)))) {
            return true;
        }
        return false;
    }

    /**
     * Calculate the month in a year according to the provided date
     * @param date The date to be calculated
     * @return The number which refers to the month in a year.
     * e.g. 1 => Jan, 2 => Feb, 3 => Mar, ... 11 => Nov, and 12 => Dec
     */
    public static int getMonth(Date date) {
        cal.setTime(date);
        return cal.get(Calendar.MONTH) + 1;
    }

    /**
     * Calculate the date in a month by the provided date
     * @param date The date to be calculated
     * @return The date in a month.
     */
    public static int getDate(Date date) {
        cal.setTime(date);
        return cal.get(Calendar.DATE);
    }

    /**
     * Check if a given date is a date on which the
     * traffic congestion tax is not imposed
     * @param date The date to be verified
     * @return True, if the date is tax-free, otherwise return false.
     */
    public static boolean isTollFreeTime(Date date) {
        cal.setTime(date);
        if (isWeekend(date) || isPublicHoliday(date)) {
            return true;
        }
        return false;
    }
}
