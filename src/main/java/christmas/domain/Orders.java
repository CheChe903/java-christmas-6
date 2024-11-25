package christmas.domain;

import static christmas.domain.Menu.MenuType.음료;

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
        int drinkSize = 0;
        int allSize = 0;
        for (Order order : orders) {
            if (order.isEqual(음료)) {
                drinkSize += order.getQuantity();
            }
            allSize += order.getQuantity();
        }
        if (drinkSize == allSize) {
            throw new IllegalArgumentException("[ERROR] 음료만 주문할 수 없습니다.");
        }
    }

    public void checkDiscount() {
        
    }

    public int getTypeSize(MenuType menuType) {
        int size = 0;
        for (Order order : orders) {
            if (order.isEqual(menuType)) {
                size += order.getQuantity();
            }
        }
        return size;
    }

    public int getTotalPrice() {
        int totalPrice = 0;
        for (Order order : orders) {
            totalPrice += order.getMenuPrice();
        }
        return totalPrice;
    }
}
