package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.Money;
import lotto.utils.validator.NumberValidator;

public class InputView {

    public static Money money() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        NumberValidator.validate(input);
        return new Money(Integer.parseInt(input));
    }
}
