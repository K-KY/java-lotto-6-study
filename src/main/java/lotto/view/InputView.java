package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.Lotto;
import lotto.model.BonusNumber;
import lotto.model.Money;
import lotto.model.WinLotto;
import lotto.utils.validator.NumberValidator;

public class InputView {

    public static Money money() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        NumberValidator.validate(input);
        return new Money(Integer.parseInt(input));
    }

    public static WinLotto winNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine().replace(" ", "");

        List<String> inputNumbers = List.of(input.split(","));
        inputNumbers.forEach(NumberValidator::validate);
        List<Integer> winNumbers = inputNumbers.stream().mapToInt(Integer::parseInt).boxed().toList();
        return new WinLotto(new Lotto(winNumbers));
    }

    public static BonusNumber bonusNumber(WinLotto winLotto) {
        System.out.println("보너스 번호를 입력해 주세요.");
        String input = Console.readLine();
        NumberValidator.validate(input);
        return new BonusNumber(Integer.parseInt(input), winLotto);
    }
}
