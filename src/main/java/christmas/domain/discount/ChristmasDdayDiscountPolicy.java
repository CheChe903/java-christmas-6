package christmas.domain.discount;

import static christmas.domain.discount.PrintDiscountPolicyDetail.CHRISTMASDDAY;

import christmas.domain.VisitingDay;

public class ChristmasDdayDiscountPolicy implements DiscountPolicy {

    private final VisitingDay visitingDay;

    public ChristmasDdayDiscountPolicy(VisitingDay visitingDay) {
        this.visitingDay = visitingDay;
    }

    @Override
    public int calculateDiscountFee() {
        if (checkCondition()) {
            return visitingDay.calculateFee();
        }
        return 0;
    }

    @Override
    public PrintDiscountPolicyDetail getPrintDiscountPolicyDetail() {
        return CHRISTMASDDAY;
    }

    @Override
    public boolean checkCondition() {
        return visitingDay.isPreviousChristmas();
    }

}
