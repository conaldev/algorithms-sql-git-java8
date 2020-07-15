public class NextDayCalculator {
    public static final int JANUARY = 1;
    public static final int FEBRUARY = 2;
    public static final int MARCH = 3;
    public static final int APRIL = 4;
    public static final int MAY = 5;
    public static final int JUNE = 6;
    public static final int JULY = 7;
    public static final int AUGUST = 8;
    public static final int SEPTEMBER = 9;
    public static final int OCTOBER = 10;
    public static final int NOVEMBER = 11;
    public static final int DECEMBER= 12;

    public static String nextDayCalculator(int day, int month, int year) {
        int maxDay = 0;
        switch (month) {
            case JANUARY:
            case MARCH:
            case MAY:
            case JULY:
            case AUGUST:
            case OCTOBER:
            case DECEMBER:
                maxDay = 31;
            break;
            case FEBRUARY:
                if (isLeapYear(year))
                    maxDay = 29;
                else
                    maxDay = 28;
                break;
            case APRIL:
            case JUNE:
            case SEPTEMBER:
            case NOVEMBER:
                maxDay = 30;
                break;
        }

        if (day == maxDay) {
            day = 1;
            if (month == 12) {
                month = 1;
                year++;
            } else
                month++;
        } else
            day++;
        String nextDay=  day + "/" + month + "/" + year;
        return nextDay;
    }

    public static boolean isLeapYear(int year) {
        boolean isDivisibleBy4 = year % 4 == 0;
        boolean isDivisibleBy100 = year % 100 == 0;
        boolean isDivisibleBy400 = year % 400 == 0;
        if (isDivisibleBy400)
            return true;
        else if (isDivisibleBy4 && !isDivisibleBy100)
            return true;
        else
            return false;
    }
}
