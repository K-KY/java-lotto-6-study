package lotto.utils.validator;

public class MoneyValidator {

    public static void isUnitFollowed(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 금액은 1000원 단위로 입력 해주세요");
        }
    }

    public static void isMinAmount(int money) {
        if (money < 1000) {
            throw new IllegalArgumentException("[ERROR] 1000원 이상의 금액을 입력 해주세요");
        }
    }

    public static void isMaxAmount(int money) {
        if (money > 1000000) {
            throw new IllegalArgumentException("[ERROR] 1000000원 이상은 입력 할 수 없습니다");
        }
    }

}
