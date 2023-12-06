package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.Lotto;

public class LottoGenerator {

    public static Lotto generate() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        List<Integer> lottoNumbers = new ArrayList<>(numbers);

        Collections.sort(lottoNumbers);
        return new Lotto(numbers);
    }
}
