package christmas.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BadgeTest {

    @ParameterizedTest
    @CsvSource({
            "6000, 별",
            "12000, 트리",
            "25000, 산타",
            "3000, 없음"
    })
    void 뱃지_테스트(int price, Badge expectedBadge) {
        assertEquals(expectedBadge, Badge.from(price));
    }
}
