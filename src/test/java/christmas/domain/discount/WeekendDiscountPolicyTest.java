package christmas.domain.discount;

import static christmas.domain.Menu.바비큐립;
import static christmas.domain.Menu.양송이수프;
import static christmas.domain.Menu.티본스테이크;
import static org.assertj.core.api.Assertions.assertThat;

import christmas.domain.Order;
import christmas.domain.Orders;
import christmas.domain.VisitingDay;
import java.util.List;
import org.junit.jupiter.api.Test;

class WeekendDiscountPolicyTest {

    @Test
    void 주말이면_메인메뉴의_갯수만큼_할인된다() {
        //given
        Order order = new Order(양송이수프, 5);
        Order order1 = new Order(티본스테이크, 5);
        Order order2 = new Order(바비큐립, 5);
        DiscountPolicy discountPolicy = new WeekendDiscountPolicy(new Orders(List.of(order2, order1, order)),
                new VisitingDay(2023, 12, 9));

        //when
        int discountAmount = discountPolicy.calculateDiscountFee();

        //then
        assertThat(discountAmount).isEqualTo(2023 * 10);
    }

}
