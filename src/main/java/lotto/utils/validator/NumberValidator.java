package lotto.utils.validator;

public class NumberValidator {
    private static final String DIGIT = "[0-9]+";
    public static void validate(String input) {
        if (!input.matches(DIGIT)) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력 해주세요");
        }
    }
}
