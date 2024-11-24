package christmas.domain;

import christmas.domain.Menu.MenuType;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Orders {

    private final List<Order> orders;

    public Orders(List<Order> orders) {
        this.orders = orders;
        validDuplicateOrder();
        validOrderSize();
        validOnlyDrinks();
    }

    private void validOrderSize() {
        int size = 0;
        for (Order order : orders) {
            size += order.getQuantity();
        }
        if (size >= 20) {
            throw new IllegalArgumentException("[ERROR] 메뉴는 한 번에 최대 20개까지만 주문할 수 있습니다.");
        }
    }

    private void validDuplicateOrder() {
        Set<Menu> menuSet = new HashSet<>();
        for (Order order : orders) {
            if (menuSet.contains(order.getMenu())) {
                throw new IllegalArgumentException("[ERROR] 메뉴는 중복될 수 없습니다.");
            }
            menuSet.add(order.getMenu());
        }
    }

    private void validOnlyDrinks() {
        Set<MenuType> typeSet = new HashSet<>();
        for (Order order : orders) {
            if (typeSet.contains(order.getMenu().getType())) {
                throw new IllegalArgumentException("[ERROR] 음료만 주문할 수 없습니다.");
            }
            typeSet.add(order.getMenu().getType());
        }
    }
}
