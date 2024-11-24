package christmas.domain;

public class VisitingDay {

    private final int day;

    public VisitingDay(int day) {
        this.day = day;
        validCorrectDay();
    }

    private void validCorrectDay() {
        if (day < 1 || day > 32) {
            throw new IllegalArgumentException("[ERROR] 방문 날짜는 1이상, 31이하입니다.");
        }
    }
}
