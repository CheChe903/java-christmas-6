package christmas.domain;

import static christmas.domain.Menu.MenuType.음료;
import static christmas.domain.Menu.양송이수프;
import static christmas.domain.Menu.제로콜라;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class OrderTest {

    @Test
    void 주문이_음료면_true를_반환한다() {
        //given
        Order order = new Order(제로콜라, 5);

        //when
        boolean isDrink = order.isEqual(음료);

        //then
        assertThat(isDrink).isEqualTo(true);
    }

    @Test
    void 주문이_음료가_아니면_false를_반환한다() {
        //given
        Order order = new Order(양송이수프, 5);

        //when
        boolean isDrink = order.isEqual(음료);

        //then
        assertThat(isDrink).isEqualTo(false);
    }


}
