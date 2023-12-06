package lotto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import lotto.model.BonusNumber;
import lotto.model.WinLotto;
import lotto.utils.validator.LottoValidator;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public Lotto(Lotto lotto) {
        numbers = lotto.numbers;
    }

    private void validate(List<Integer> numbers) {
        LottoValidator.isValidSize(numbers);
        LottoValidator.isValidRange(numbers);
        LottoValidator.isDuplicate(numbers);
    }

    // TODO: 추가 기능 구현


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Lotto lotto = (Lotto) o;
        return Objects.equals(numbers, lotto.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

    public boolean containsNumber(int bonusNumber) {
        return numbers.contains(bonusNumber);
    }

    public boolean containsNumber(BonusNumber bonusNumber) {
        return bonusNumber.isContains(numbers);
    }

    public void containsLotto(WinLotto winLotto, HashMap<Integer, List<Lotto>> winLottos) {
        int containsCount = (int) numbers.stream().filter(winLotto::containsNumber).count();
        List<Lotto> lotto = winLottos.getOrDefault(containsCount, new ArrayList<>());
        lotto.add(new Lotto(numbers));
        winLottos.put(containsCount, lotto);
    }

    public boolean containsBonusNumber(BonusNumber bonusNumber, Lotto winFive) {
        return winFive.containsNumber(bonusNumber);
//        return winFive.stream().filter(lotto -> bonusNumber.isContains(numbers)).collect(Collectors.toList());
    }
}
