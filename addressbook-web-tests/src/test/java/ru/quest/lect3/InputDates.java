package ru.quest.lect3;

public class InputDates {
    private final String bDayDay;
    private final String bDayMonth;
    private final String bDayYear;
    private final String aDayDay;
    private final String aDayMonth;
    private final String aDayYear;



    public InputDates(String bDayDay, String bDayMonth, String bDayYear, String aDayDay, String aDayMonth, String aDayYear) {
        this.bDayDay = bDayDay;
        this.bDayMonth = bDayMonth;
        this.bDayYear = bDayYear;
        this.aDayDay = aDayDay;
        this.aDayMonth = aDayMonth;
        this.aDayYear = aDayYear;
    }

    public String getbDayDay() {
        return bDayDay;
    }

    public String getbDayMonth() {
        return bDayMonth;
    }

    public String getbDayYear() {
        return bDayYear;
    }

    public String getaDayDay() {
        return aDayDay;
    }

    public String getaDayMonth() {
        return aDayMonth;
    }

    public String getaDayYear() {
        return aDayYear;
    }


}
