package christmas.domain.discount;

public class SpecialDiscountPolicy implements DiscountPolicy {
    
    public SpecialDiscountPolicy() {
    }

    @Override
    public int calculateDiscountFee() {
        return 1000;
    }
}
