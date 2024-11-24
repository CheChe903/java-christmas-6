package christmas.domain;

import static christmas.domain.Menu.MenuType.음료;

public class Order {

    private final Menu menu;
    private final int quantity;

    public Order(Menu menu, int quantity) {
        this.menu = menu;
        this.quantity = quantity;
    }

    public boolean isDrink() {
        return menu.getType().equals(음료);
    }

    public int getQuantity() {
        return quantity;
    }

    public Menu getMenu() {
        return menu;
    }
}
