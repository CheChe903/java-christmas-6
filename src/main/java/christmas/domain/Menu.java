package christmas.domain;

import static christmas.domain.Menu.MenuType.디저트;
import static christmas.domain.Menu.MenuType.메인;
import static christmas.domain.Menu.MenuType.에피타이저;
import static christmas.domain.Menu.MenuType.음료;

public enum Menu {

    없음(MenuType.없음, 0),

    양송이수프(에피타이저, 6000),
    타파스(에피타이저, 5500),
    시저샐러드(에피타이저, 8000),

    티본스테이크(메인, 55000),
    바비큐립(메인, 54000),
    해산물파스타(메인, 35000),
    크리스마스파스타(메인, 25000),

    초코케이크(디저트, 15000),
    아이스크림(디저트, 5000),

    제로콜라(음료, 3000),
    레드와인(음료, 60000),
    샴페인(음료, 25000);

    private final MenuType menuType;
    private final int price;

    Menu(MenuType menuType, int price) {
        this.menuType = menuType;
        this.price = price;
    }

    public static Menu from(String name) {
        for (Menu menu : Menu.values()) {
            if (name.equals(menu.name())) {
                return menu;
            }
        }
        throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
    }

    public boolean isEqual(MenuType menuType) {
        return this.menuType == menuType;
    }

    public String getName() {
        return this.toString();
    }

    public int getPrice() {
        return this.price;
    }

    public enum MenuType {
        에피타이저,
        메인,
        디저트,
        음료,
        없음;

    }
}
