package christmas;

import java.util.Arrays;
import java.util.Comparator;

public enum Badge implements Comparator<Badge> {

    없음(0),
    별(5000),
    트리(10000),
    산타(20000);

    private final int price;

    Badge(int price) {
        this.price = price;
    }

    public static Badge from(int price) {
        Badge previousBadge = 없음;
        Badge[] badges = Badge.values();
        Arrays.sort(badges);

        for (Badge badge : badges) {
            if (badge.price > price) {
                return previousBadge;
            }
            previousBadge = badge;
        }
        return previousBadge;
    }

    @Override
    public int compare(Badge o1, Badge o2) {
        return o1.price - o2.price;
    }
}
