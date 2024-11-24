package christmas.domain.discount;

import static christmas.domain.Menu.바비큐립;
import static christmas.domain.Menu.초코케이크;
import static christmas.domain.Menu.티본스테이크;
import static org.assertj.core.api.Assertions.assertThat;

import christmas.domain.Order;
import christmas.domain.Orders;
import java.util.List;
import org.junit.jupiter.api.Test;

class WeeksDaysDiscountPolicyTest {

    @Test
    void 평일이면_메인메뉴의_갯수만큼_할인된다() {
        //given
        Order order = new Order(초코케이크, 5);
        Order order1 = new Order(티본스테이크, 5);
        Order order2 = new Order(바비큐립, 5);
        DiscountPolicy discountPolicy = new WeeksDaysDiscountPolicy(new Orders(List.of(order2, order1, order)));

        //when
        int discountAmount = discountPolicy.calculateDiscountFee();

        //then
        assertThat(discountAmount).isEqualTo(2023 * 5);
    }

}
