package christmas.domain.discount;

import static christmas.domain.Menu.샴페인;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class PresentationEventDiscountPolicyTest {

    @Test
    void 일정금액이_넘어가면_증정품이_증정된다() {
        //given
        DiscountPolicy discountPolicy = new PresentationEventDiscountPolicy(샴페인);

        //when
        int discountAmount = discountPolicy.calculateDiscountFee();

        //then
        assertThat(discountAmount).isEqualTo(샴페인.getPrice());
    }

}
