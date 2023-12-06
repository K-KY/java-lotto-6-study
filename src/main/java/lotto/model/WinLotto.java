package lotto.model;

import lotto.Lotto;

public class WinLotto extends Lotto{
    private final Lotto lotto;

    public WinLotto(Lotto lotto) {
        super(lotto);
        this.lotto = lotto;
    }
}
