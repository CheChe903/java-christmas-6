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

    OutputView outputView = new OutputView();
    InputView inputView = new InputView();

    public void start() {
        outputView.printStartingPhrase();
        VisitingDay visitingDay = new VisitingDay(2023, 12, Integer.parseInt(inputView.enterVisitDate()));

        outputView.printBanner(visitingDay.getDay());

        String orderInput = inputView.enterOrderMenu();

        Pattern pattern = Pattern.compile(PATTERN);

        Matcher matcher = pattern.matcher(orderInput);
        List<Order> orders1 = new ArrayList<>();

        if (!matcher.matches()) {
            throw new IllegalArgumentException("[ERROR] 형식에 맞지 않습니다.");
        }
        matcher.reset();
        while (matcher.find()) {
            Order order = new Order(Menu.from(matcher.group(0)), Integer.parseInt(matcher.group(1)));
            orders1.add(order);
        }

        Orders orders = new Orders(orders1);

        outputView.printOrderDetails(orders1);

        outputView.printTotalPrice(orders.getTotalPrice());

        PromotionProcessor promotionProcessor = new PromotionProcessor(visitingDay, orders.getTotalPrice(), orders);
        outputView.printGiveawayMenu(promotionProcessor.getPresentation().getPresentation(),
                promotionProcessor.getPresentation().getQuantity());
        outputView.printBenefitDetails(promotionProcessor.checkPromotion());

        outputView.printTotalBenefitAmount(promotionProcessor.getTotalBenefitAmount());

        outputView.printDepositAmountAfterDiscount(orders.getTotalPrice() - promotionProcessor.getTotalBenefitAmount());

        outputView.printBadge(Badge.from(promotionProcessor.getTotalBenefitAmount()));
    }
}
