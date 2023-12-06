package lotto.utils.validator;

import java.util.List;
import lotto.model.WinLotto;

public class BonusNumberValidator {

    public static void isInRange(int number) {
        LottoValidator.isValidRange(List.of(number));
    }

    public static void isDuplicate(int number, WinLotto winLotto) {
        if (!winLotto.containsNumber(number)) {
            return;
        }
        throw new IllegalArgumentException("[ERROR] 당첨 번호와 중복되지 않는 번호를 입력 해주세요");
    }
}
