package christmas.domain.discount;

import static christmas.domain.Menu.MenuType.디저트;
import static christmas.domain.discount.PrintDiscountPolicyDetail.WEEKSDAY;

import christmas.domain.Orders;
import christmas.domain.VisitingDay;

public class WeeksDaysDiscountPolicy implements DiscountPolicy {

    private final Orders orders;
    private final VisitingDay visitingDay;

    public WeeksDaysDiscountPolicy(Orders orders, VisitingDay visitingDay) {
        this.orders = orders;
        this.visitingDay = visitingDay;
    }

    @Override
    public int calculateDiscountFee() {
        if (checkCondition()) {
            return orders.getTypeSize(디저트) * 2023;
        }
        return 0;
    }

    @Override
    public PrintDiscountPolicyDetail getPrintDiscountPolicyDetail() {
        return WEEKSDAY;
    }

    @Override
    public boolean checkCondition() {
        return !visitingDay.isWeekend();
    }

}
