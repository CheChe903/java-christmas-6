package christmas.domain;

import static java.time.DayOfWeek.FRIDAY;
import static java.time.DayOfWeek.SATURDAY;
import static java.time.DayOfWeek.SUNDAY;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class VisitingDay {

    private final int year;
    private final int month;
    private final int day;

    public VisitingDay(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
        validCorrectDay();
    }

    private void validCorrectDay() {
        if (day < 1 || day > 32) {
            throw new IllegalArgumentException("[ERROR] 방문 날짜는 1이상, 31이하입니다.");
        }
    }

    public LocalDate getLocalDate() {
        return LocalDate.of(year, month, day);
    }

    public boolean isSpecialDay() {
        LocalDate date = getLocalDate();
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        return day == 25 || dayOfWeek == SUNDAY;
    }

    public boolean isWeekend() {
        LocalDate date = getLocalDate();
        DayOfWeek dayOfWeek = date.getDayOfWeek();

        return dayOfWeek == FRIDAY || dayOfWeek == SATURDAY;

    }

    public boolean isChristmas() {
        return day == 25;
    }

    public int calculateFee() {
        return 1000 + (day * 100);
    }

    public int getDay() {
        return day;
    }

}
