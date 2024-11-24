package christmas.domain.discount;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class SpecialDiscountPolicyTest {

    @Test
    void 특별할인이_존재하면_일정금액을_할인한다() {
        //given
        DiscountPolicy discountPolicy = new SpecialDiscountPolicy();

        //when
        int discountAmount = discountPolicy.calculateDiscountFee();

        //then
        assertThat(discountAmount).isEqualTo(1000);
    }

}
