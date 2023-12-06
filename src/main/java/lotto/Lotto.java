package lotto;

import java.util.List;
import java.util.Objects;
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
}
