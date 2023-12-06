package lotto.utils;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.view.InputView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ValidateLooperTest extends NsTest {

    @Test
    @DisplayName("재시작")
    void money() {
        assertSimpleTest(() -> {
            runException("1000j","1000");
            assertThat(output()).contains("[ERROR]");
        });
    }

    @Test
    @DisplayName("1000원 이하의 금액 입력")
    void moneyUnderMinAmount() {
        assertSimpleTest(() -> {
            runException("0", "100");
            assertThat(output()).contains("[ERROR]");
        });
    }

    @Test
    @DisplayName("1000000원 이상의 금액 입력")
    void moneyOverMaxAmount() {
        assertSimpleTest(() -> {
            runException("10000000");
            assertThat(output()).contains("[ERROR]");
        });
    }

    @Test
    @DisplayName("1000으로 나누어 떨어지지 않는 값 입력")
    void unitFollowed() {
        assertSimpleTest(() -> {
            runException("1001");
            assertThat(output()).contains("[ERROR]");
        });
    }

    @Override
    protected void runMain() {
        ValidateLooper.read(InputView::money);
    }
}