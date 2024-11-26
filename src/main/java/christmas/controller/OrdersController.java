package christmas.controller;

import christmas.Badge;
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
        outputView.printStartingPhrase();
        VisitingDay visitingDay = new VisitingDay(2023, 12, Integer.parseInt(inputView.enterVisitDate()));

        String orderInput = inputView.enterOrderMenu();

        outputView.printBanner(visitingDay.getDay());

        Pattern pattern = Pattern.compile(PATTERN);

        String[] orderItems = orderInput.split(",");
        List<Order> orders1 = new ArrayList<>();

        for (String item : orderItems) {
            Matcher matcher = pattern.matcher(item.trim());
            if (!matcher.matches()) {
                throw new IllegalArgumentException("[ERROR] 형식에 맞지 않습니다: " + item);
            }
            Order order = new Order(Menu.from(matcher.group(1)), Integer.parseInt(matcher.group(2)));
            orders1.add(order);
        }

        Orders orders = new Orders(orders1);

        outputView.printOrderDetails(orders1);

        outputView.printTotalPrice(orders.getTotalPrice());

        PromotionProcessor promotionProcessor = new PromotionProcessor(visitingDay, orders.getTotalPrice(), orders);
        promotionProcessor.checkPromotion();

        outputView.printGiveawayMenu(promotionProcessor.getPresentation().getPresentation(),
                promotionProcessor.getPresentation().getQuantity());
        outputView.printBenefitDetails(promotionProcessor.getDiscountPolicies());

        outputView.printTotalBenefitAmount(promotionProcessor.getTotalBenefitAmount());

        outputView.printDepositAmountAfterDiscount(
                orders.getTotalPrice() - promotionProcessor.getTotalBenefitAmountExcludingGiftEvent());

        outputView.printBadge(Badge.from(promotionProcessor.getTotalBenefitAmount()));
    }

}
