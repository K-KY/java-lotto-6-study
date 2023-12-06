package lotto.model;

import lotto.utils.validator.BonusNumberValidator;

public class BonusNumber {
    private final int bonusNumber;

    public BonusNumber(int number, WinLotto winLotto) {
        this.bonusNumber = number;
        validate(winLotto);
    }

    private void validate(WinLotto winLotto) {
        BonusNumberValidator.isInRange(bonusNumber);
        BonusNumberValidator.isDuplicate(bonusNumber, winLotto);
    }
}
