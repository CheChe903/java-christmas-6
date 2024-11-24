package christmas.domain.discount;

import static christmas.domain.Menu.MenuType.디저트;
import static christmas.domain.Menu.MenuType.메인;

import christmas.domain.Orders;

public class DayOfTheWeekDiscountPolicy implements DiscountPolicy {

    private final Orders orders;
    private final int day;


    public DayOfTheWeekDiscountPolicy(Orders orders, int day) {
        this.orders = orders;
        this.day = day;
    }

    @Override
    public int calculateDiscountFee() {
        if (day == 0 || day == 6) {
            return orders.getTypeSize(메인) * 2023;
        }
        return orders.getTypeSize(디저트) * 2023;
    }
}
