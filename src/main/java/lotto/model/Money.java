package lotto.model;

import lotto.utils.validator.MoneyValidator;

public class Money {
    private final int money;

    public Money(int money) {
        this.money = money;
        validate();
    }

    private void validate() {
        MoneyValidator.isUnitFollowed(money);
        MoneyValidator.isMinAmount(money);
        MoneyValidator.isMaxAmount(money);
    }
}
