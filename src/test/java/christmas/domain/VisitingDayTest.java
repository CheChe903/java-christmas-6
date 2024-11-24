package christmas.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class VisitingDayTest {

    @Test
    void 날짜가_올바르지_않으면_예외를_발생한다() {
        //when & then
        assertThatThrownBy(() -> new VisitingDay(0))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 입력_날짜에_따라_할인_금액이_결정된다() {
        //given
        VisitingDay visitingDay = new VisitingDay(5);

        //when
        int discountFee = visitingDay.calculateFee();

        //then
        assertThat(discountFee).isEqualTo(1500);
    }

    @Test
    void 입력_날짜가_26이상이면_할인_금액이_0이다() {
        //given
        VisitingDay visitingDay = new VisitingDay(26);

        //when
        int discountFee = visitingDay.calculateFee();

        //then
        assertThat(discountFee).isEqualTo(0);
    }
}
