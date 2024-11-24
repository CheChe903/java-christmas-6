package christmas.domain;

import christmas.domain.Menu.MenuType;

public class Order {

    private final Menu menu;
    private final int quantity;

    public Order(Menu menu, int quantity) {
        this.menu = menu;
        this.quantity = quantity;
    }

    public boolean isEqual(MenuType menuType) {
        return menu.isEqual(menuType);
    }

    public int getQuantity() {
        return quantity;
    }

    public Menu getMenu() {
        return menu;
    }
}
