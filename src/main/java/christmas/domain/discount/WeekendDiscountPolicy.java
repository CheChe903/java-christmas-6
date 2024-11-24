package christmas.domain.discount;

import static christmas.domain.Menu.MenuType.메인;

import christmas.domain.Orders;

public class WeekendDiscountPolicy implements DiscountPolicy {

    private final Orders orders;

    public WeekendDiscountPolicy(Orders orders) {
        this.orders = orders;
    }

    @Override
    public int calculateDiscountFee() {
        return orders.getTypeSize(메인) * 2023;

    }

}
