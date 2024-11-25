package christmas.domain;

import static christmas.domain.Menu.샴페인;

import christmas.domain.discount.ChristmasDdayDiscountPolicy;
import christmas.domain.discount.DiscountPolicy;
import christmas.domain.discount.PresentationEventDiscountPolicy;
import christmas.domain.discount.SpecialDiscountPolicy;
import christmas.domain.discount.WeekendDiscountPolicy;
import christmas.domain.discount.WeeksDaysDiscountPolicy;
import java.time.LocalDate;
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

    public List<DiscountPolicy> checkPromotion() {
        if (totalPrice < 10000) {
            return new ArrayList<>();
        }
        discountPolicies = List.of(
                new ChristmasDdayDiscountPolicy(visitingDay), new WeekendDiscountPolicy(orders, visitingDay),
                new WeeksDaysDiscountPolicy(orders, visitingDay), new SpecialDiscountPolicy(visitingDay),
                new PresentationEventDiscountPolicy(샴페인, totalPrice, 1)
        );
        LocalDate date = visitingDay.getLocalDate();

        return discountPolicies;
    }

    public PresentationEventDiscountPolicy getPresentation() {
        return (PresentationEventDiscountPolicy) discountPolicies.get(4);
    }

    public int getTotalBenefitAmount() {
        int totalBenefitAmount = 0;
        for (DiscountPolicy discountPolicy : discountPolicies) {
            totalBenefitAmount += discountPolicy.calculateDiscountFee();
        }
        return totalBenefitAmount;
    }
}
