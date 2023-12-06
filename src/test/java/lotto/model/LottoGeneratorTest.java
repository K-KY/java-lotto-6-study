package lotto.model;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import lotto.Lotto;
import org.junit.jupiter.api.Test;

class LottoGeneratorTest extends NsTest {

    @Test
    void generate() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run();
                    assertThat(LottoGenerator.generate()).isEqualTo(new Lotto(List.of(8, 21, 23, 41, 42, 43)));
                },
                List.of(8, 21, 23, 41, 42, 43)
        );
    }

    @Override
    protected void runMain() {
        LottoGenerator.generate();
    }
}