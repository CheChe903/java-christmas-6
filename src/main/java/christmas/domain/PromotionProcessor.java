package christmas.domain;

import static christmas.domain.Menu.샴페인;
import static christmas.domain.Menu.없음;

import christmas.domain.discount.ChristmasDdayDiscountPolicy;
import christmas.domain.discount.DiscountPolicy;
import christmas.domain.discount.PresentationEventDiscountPolicy;
import christmas.domain.discount.SpecialDiscountPolicy;
import christmas.domain.discount.WeekendDiscountPolicy;
import christmas.domain.discount.WeeksDaysDiscountPolicy;
import java.util.ArrayList;
import java.util.List;

public class PromotionProcessor {

    private List<DiscountPolicy> discountPolicies;
    private final VisitingDay visitingDay;
    private final int totalPrice;
    private final Orders orders;

    public PromotionProcessor(VisitingDay visitingDay, int totalPrice, Orders orders) {
        this.discountPolicies = new ArrayList<>();
        this.visitingDay = visitingDay;
        this.totalPrice = totalPrice;
        this.orders = orders;
    }

    public void checkPromotion() {
        if (totalPrice < 10000) {
            return;
        }
        discountPolicies = List.of(
                new ChristmasDdayDiscountPolicy(visitingDay), new WeekendDiscountPolicy(orders, visitingDay),
                new WeeksDaysDiscountPolicy(orders, visitingDay), new SpecialDiscountPolicy(visitingDay),
                new PresentationEventDiscountPolicy(샴페인, totalPrice, 1)
        );
    }

    public PresentationEventDiscountPolicy getPresentation() {
        for (DiscountPolicy policy : discountPolicies) {
            if (policy instanceof PresentationEventDiscountPolicy) {
                return (PresentationEventDiscountPolicy) policy;
            }
        }
        return new PresentationEventDiscountPolicy(없음, totalPrice, 0);
    }

    public List<DiscountPolicy> getDiscountPolicies() {
        return new ArrayList<>(discountPolicies);
    }

    public int getTotalBenefitAmount() {
        int totalBenefitAmount = 0;
        for (DiscountPolicy discountPolicy : discountPolicies) {
            totalBenefitAmount += discountPolicy.calculateDiscountFee();
        }
        return totalBenefitAmount;
    }

    public int getTotalBenefitAmountExcludingGiftEvent() {
        int totalBenefitAmount = 0;
        for (DiscountPolicy discountPolicy : discountPolicies) {
            if (discountPolicy instanceof PresentationEventDiscountPolicy) {
                continue;
            }
            totalBenefitAmount += discountPolicy.calculateDiscountFee();
        }
        return totalBenefitAmount;
    }
}
