package christmas.domain.discount;

public class PresentationEventDiscountPolicy implements DiscountPolicy {

    private final int totalAmount;

    public PresentationEventDiscountPolicy(int totalAmount) {
        this.totalAmount = totalAmount;
    }

    @Override
    public int calculateDiscountFee() {
        if (totalAmount >= 120000) {
            return 25000;
        }
        return 0;
    }
}
