package christmas.view;

import static christmas.domain.Menu.MenuType.없음;

import christmas.Badge;
import christmas.domain.Menu;
import christmas.domain.Order;
import christmas.domain.discount.DiscountPolicy;
import java.util.List;

public class OutputView {

    public static final String DELIMITER = "-%,d원";

    public void printStartingPhrase() {
        System.out.println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.");
    }

    public void printBanner(int day) {
        System.out.println("12월 " + day + "일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!");
    }

    public void printOrderDetails(List<Order> orders) {
        System.out.println();
        System.out.println("<주문 메뉴>");
        StringBuilder sb = new StringBuilder();
        for (Order order : orders) {
            sb.append(order.getName()).append(" ").append(order.getQuantity()).append("개").append("\n");
        }
        System.out.println(sb);
    }

    public void printTotalPrice(int totalPrice) {
        System.out.println("<할인 전 총주문 금액>");
        System.out.println(totalPrice);
        System.out.println();
    }

    public void printGiveawayMenu(Menu menu, int quantity) {
        System.out.println("<증정 메뉴>");
        if (menu.isEqual(없음)) {
            System.out.printf("%s", menu.getName());
            System.out.println();
            return;
        }

        System.out.printf("%s %d개", menu.getName(), quantity);
        System.out.println();
    }

    public void printBenefitDetails(List<DiscountPolicy> discountPolicies) {
        System.out.println("<혜택 내역>");
        StringBuilder sb = new StringBuilder();

        for (DiscountPolicy discountPolicy : discountPolicies) {
            if (discountPolicy.calculateDiscountFee() > 0) {
                sb.append(String.format("%s: -%,d원", discountPolicy.getPrintDiscountPolicyDetail().getTitle()
                        , discountPolicy.calculateDiscountFee())).append("\n");
            }
        }

        if (sb.isEmpty()) {
            System.out.println("없음");
            return;
        }
        System.out.println(sb);
    }

    public void printTotalBenefitAmount(int totalBenefitAmount) {
        System.out.println("<총 혜택 금액>");
        System.out.printf("%,d원", totalBenefitAmount);
        System.out.println();
    }

    public void printDepositAmountAfterDiscount(int amount) {
        System.out.println("<할인 후 예상 결제 금액>");
        System.out.printf("%,d원", amount);
        System.out.println();
    }

    public void printBadge(Badge badge) {
        System.out.println("<12월 이벤트 배지>");
        System.out.println(badge.name());
    }
}
