package christmas.domain.discount;

public enum PrintDiscountPolicyDetail {

    CHRISTMASDDAY("크리스마스 디데이 할인"),
    WEEKSDAY("평일 할인"),
    WEEKEND("주말 할인"),
    SPECIAL("특별 할인"),
    PRESENTATION("증정 이벤트");

    private final String title;

    PrintDiscountPolicyDetail(String title) {
        this.title = title;
    }


    public String getTitle() {
        return title;
    }

}
