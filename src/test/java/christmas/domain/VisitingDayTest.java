package christmas.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class VisitingDayTest {

    @Test
    void 날짜가_올바르지_않으면_예외를_발생한다() {
        //when & then
        assertThatThrownBy(() -> new VisitingDay(0))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
