package christmas.domain;

import static christmas.domain.Menu.레드와인;
import static christmas.domain.Menu.양송이수프;
import static christmas.domain.Menu.제로콜라;
import static christmas.domain.Menu.타파스;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;

class OrdersTest {

    @Test
    void 메뉴갯수가_20개_넘어갈_경우_예외를_발생한다() {
        //given
        Order order = new Order(양송이수프, 10);
        Order order1 = new Order(타파스, 11);

        //when & then
        assertThatThrownBy(() -> new Orders(List.of(order, order1)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 메뉴갯수가_중복될_경우_예외를_발생한다() {
        //given
        Order order = new Order(양송이수프, 10);
        Order order1 = new Order(양송이수프, 5);

        //when & then
        assertThatThrownBy(() -> new Orders(List.of(order, order1)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 음료만_주문될_경우_예외를_발생한다() {
        //given
        Order order = new Order(제로콜라, 10);
        Order order1 = new Order(레드와인, 5);

        //when & then
        assertThatThrownBy(() -> new Orders(List.of(order, order1)))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
