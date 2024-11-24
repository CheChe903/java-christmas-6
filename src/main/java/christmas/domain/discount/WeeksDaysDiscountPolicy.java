package christmas.domain.discount;

import static christmas.domain.Menu.MenuType.디저트;

import christmas.domain.Orders;

public class WeeksDaysDiscountPolicy implements DiscountPolicy {

    private final Orders orders;

    public WeeksDaysDiscountPolicy(Orders orders) {
        this.orders = orders;
    }

    @Override
    public int calculateDiscountFee() {
        return orders.getTypeSize(디저트) * 2023;

    }
}
