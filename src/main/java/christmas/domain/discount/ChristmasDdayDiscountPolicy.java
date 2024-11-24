package christmas.domain.discount;

import christmas.domain.VisitingDay;

public class ChristmasDdayDiscountPolicy implements DiscountPolicy {

    private final VisitingDay visitingDay;

    public ChristmasDdayDiscountPolicy(VisitingDay visitingDay) {
        this.visitingDay = visitingDay;
    }

    @Override
    public int calculateDiscountFee() {
        return visitingDay.calculateFee();
    }
}
