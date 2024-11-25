package christmas.domain.discount;

public interface DiscountPolicy {

    int calculateDiscountFee();

    PrintDiscountPolicyDetail getPrintDiscountPolicyDetail();

    boolean checkCondition();
}
