package christmas.domain.discount;

import static christmas.domain.discount.PrintDiscountPolicyDetail.PRESENTATION;

import christmas.domain.Menu;

public class PresentationEventDiscountPolicy implements DiscountPolicy {

    private final Menu menu;
    private final int totalAmount;
    private final int quantity;

    public PresentationEventDiscountPolicy(Menu menu, int totalAmount, int quantity) {
        this.menu = menu;
        this.totalAmount = totalAmount;
        this.quantity = quantity;
    }

    @Override
    public int calculateDiscountFee() {
        return menu.getPrice();
    }

    @Override
    public PrintDiscountPolicyDetail getPrintDiscountPolicyDetail() {
        return PRESENTATION;
    }

    @Override
    public boolean checkCondition() {
        return totalAmount >= 120000;
    }

    public Menu getPresentation() {
        return menu;
    }

    public int getQuantity() {
        return quantity;
    }
}
