package lotto.model;

import lotto.utils.validator.MoneyValidator;

public class Money {
    private final int money;

    public Money(int money) {
        this.money = money;
        validate();
    }

    private void validate() {
        MoneyValidator.isMinAmount(money);
        MoneyValidator.isUnitFollowed(money);
        MoneyValidator.isMaxAmount(money);
    }

    public int purchaseAmount() {
        return money / 1000;
    }
}
