package lotto.controller;

import lotto.model.BonusNumber;
import lotto.model.CompareLotto;
import lotto.model.Money;
import lotto.model.PurchaseLotto;
import lotto.model.TotalRevenue;
import lotto.model.WinLotto;
import lotto.utils.ValidateLooper;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private CompareLotto compareLotto = new CompareLotto();
    private TotalRevenue totalRevenue = new TotalRevenue();
    public void start() {
        Money money = ValidateLooper.read(InputView::money);
        PurchaseLotto purchaseLotto = new PurchaseLotto(money);
        System.out.println(purchaseLotto);
        WinLotto winNumbers = ValidateLooper.read(InputView::winNumber);
        BonusNumber bonusNumber = ValidateLooper.read(InputView::bonusNumber, winNumbers);
        compareLotto.compare(purchaseLotto, winNumbers);
        compareLotto.compareBonusNumber(bonusNumber);
        compareLotto.getRevenue(totalRevenue);
        OutputView.printResult(compareLotto);
        OutputView.printStatistics(totalRevenue.getTotalRevenue(), money.purchaseAmount());
    }
}
