package lotto.model;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;
import lotto.Lotto;

public class PurchaseLotto {
    private final List<Lotto> generatedLotto;
    public PurchaseLotto(Money money) {
        this.generatedLotto = new ArrayList<>();
        buy(money);
    }
    private void buy(Money money) {
        int amount = money.purchaseAmount();
        for (int i = 0; i < amount; i++) {
            generatedLotto.add(LottoGenerator.generate());
        }
    }

    @Override
    public String toString() {
        StringJoiner lottoIndicator = new StringJoiner("\n");
        generatedLotto.forEach(lotto -> lottoIndicator.add(lotto.toString()));
        return generatedLotto.size() + "개를 구매 했습니다.\n"+lottoIndicator;
    }
}
