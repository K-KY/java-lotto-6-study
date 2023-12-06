package lotto.model;

import java.util.List;
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

    public boolean isContains(List<Integer> numbers) {
        return numbers.contains(bonusNumber);
    }
}
