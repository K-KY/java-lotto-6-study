package lotto.utils;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.view.InputView;
import org.junit.jupiter.api.Test;

class ValidateLooperTest extends NsTest {

    @Test
    void money() {
        assertSimpleTest(() -> {
            runException("1000j","1000");
            assertThat(output()).contains("[ERROR]");
        });
    }

    @Override
    protected void runMain() {
        ValidateLooper.read(InputView::money);
    }
}