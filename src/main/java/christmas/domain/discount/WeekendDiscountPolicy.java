package christmas.domain.discount;

import static christmas.domain.Menu.MenuType.메인;
import static christmas.domain.discount.PrintDiscountPolicyDetail.WEEKEND;

import christmas.domain.Orders;
import christmas.domain.VisitingDay;

public class WeekendDiscountPolicy implements DiscountPolicy {

    private final Orders orders;
    private final VisitingDay visitingDay;

    public WeekendDiscountPolicy(Orders orders, VisitingDay visitingDay) {
        this.orders = orders;
        this.visitingDay = visitingDay;
    }

    @Override
    public int calculateDiscountFee() {
        if (checkCondition()) {
            return orders.getTypeSize(메인) * 2023;
        }
        return 0;
    }

    @Override
    public PrintDiscountPolicyDetail getPrintDiscountPolicyDetail() {
        return WEEKEND;
    }

    @Override
    public boolean checkCondition() {
        return visitingDay.isWeekend();
    }

}
