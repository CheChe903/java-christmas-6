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
        if (day < 1 || day > 31) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
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

    public boolean isPreviousChristmas() {
        return day <= 25;
    }

    public int calculateFee() {
        return 900 + (day * 100);
    }

    public int getDay() {
        return day;
    }

}
