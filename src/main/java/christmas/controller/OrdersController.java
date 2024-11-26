package christmas.controller;

import christmas.domain.Badge;
import christmas.domain.Menu;
import christmas.domain.Order;
import christmas.domain.Orders;
import christmas.domain.PromotionProcessor;
import christmas.domain.VisitingDay;
import christmas.view.InputView;
import christmas.view.OutputView;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OrdersController {

    private static final String PATTERN = "^([가-힣]+)-(\\d+)$";

    private final InputView inputView;
    private final OutputView outputView;

    public OrdersController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void start() {
        try {
            outputView.printStartingPhrase();
            VisitingDay visitingDay = new VisitingDay(2023, 12, inputVisitingDay());
            Orders orders = new Orders(inputMenu(visitingDay.getDay()));
            printOrderAndPrice(orders);
            PromotionProcessor promotionProcessor = new PromotionProcessor(visitingDay, orders.getTotalPrice(), orders);
            promotionProcessor.checkPromotion();
            printResult(promotionProcessor, orders);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            start();
        }

    }

    private void printResult(PromotionProcessor promotionProcessor, Orders orders) {
        outputView.printGiveawayMenu(promotionProcessor.getPresentation().getPresentation(),
                promotionProcessor.getPresentation().getQuantity());
        outputView.printBenefitDetails(promotionProcessor.getDiscountPolicies());
        outputView.printTotalBenefitAmount(promotionProcessor.getTotalBenefitAmount());
        outputView.printDepositAmountAfterDiscount(
                orders.getTotalPrice() - promotionProcessor.getTotalBenefitAmountExcludingGiftEvent());
        outputView.printBadge(Badge.from(promotionProcessor.getTotalBenefitAmount()));
    }

    private void printOrderAndPrice(Orders orders) {
        outputView.printOrderDetails(orders.getOrder());

        outputView.printTotalPrice(orders.getTotalPrice());
    }

    private int inputVisitingDay() {
        try {
            return Integer.parseInt(inputView.enterVisitDate());
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");

        }
        return inputVisitingDay();

    }

    private List<Order> inputMenu(int day) {
        String orderInput = inputView.enterOrderMenu();

        outputView.printBanner(day);

        Pattern pattern = Pattern.compile(PATTERN);

        String[] orderItems = orderInput.split(",");
        List<Order> orders = new ArrayList<>();

        for (String item : orderItems) {
            Matcher matcher = pattern.matcher(item.trim());
            if (!matcher.matches()) {
                System.out.println("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
                inputMenu(day);
            }
            Order order = new Order(Menu.from(matcher.group(1)), Integer.parseInt(matcher.group(2)));
            orders.add(order);
        }
        return orders;
    }
}
