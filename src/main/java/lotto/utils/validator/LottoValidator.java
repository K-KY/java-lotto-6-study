package lotto.utils.validator;

import java.util.List;

public class LottoValidator {

    public static void isValidSize(List<Integer> lottoNumbers) {
        if (lottoNumbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 6개의 숫자를 입력 해주세요");
        }
    }

    public static void isValidRange(List<Integer> lottoNumbers) {
        lottoNumbers.forEach(LottoValidator::checkRange);
    }

    private static void checkRange(int number) {
        if (number > 45) {
            throw new IllegalArgumentException("[ERROR] 45이하의 숫자를 입력 해주세요.");
        }
        if (number < 1) {
            throw new IllegalArgumentException("[ERROR] 1이상의 숫자를 입력 해주세요.");
        }
    }

    public static void isDuplicate(List<Integer> lottoNumbers) {
        if (lottoNumbers.stream().distinct().count() != lottoNumbers.size()) {
            throw new IllegalArgumentException("[ERROR] 중복되지 않는 숫자를 입력 해주세요");
        }
    }
}
