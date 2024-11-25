package christmas.domain.discount;

import static christmas.domain.discount.PrintDiscountPolicyDetail.SPECIAL;

import christmas.domain.VisitingDay;

public class SpecialDiscountPolicy implements DiscountPolicy {

    private final VisitingDay visitingDay;

    public SpecialDiscountPolicy(VisitingDay visitingDay) {
        this.visitingDay = visitingDay;
    }

    @Override
    public int calculateDiscountFee() {
        if (checkCondition()) {
            return 1000;
        }
        return 0;
    }

    @Override
    public PrintDiscountPolicyDetail getPrintDiscountPolicyDetail() {
        return SPECIAL;
    }

    @Override
    public boolean checkCondition() {
        return visitingDay.isSpecialDay();
    }
}
