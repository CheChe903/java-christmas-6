package christmas.domain;

public class Order {

    private final Menu menu;
    private final int quantity;

    public Order(Menu menu, int quantity) {
        this.menu = menu;
        this.quantity = quantity;
    }

    public boolean isDrink() {
        return menu.isDrink();
    }

    public int getQuantity() {
        return quantity;
    }

    public Menu getMenu() {
        return menu;
    }
}
