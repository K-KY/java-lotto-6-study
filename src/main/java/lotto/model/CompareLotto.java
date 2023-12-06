package lotto.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import lotto.Lotto;
import lotto.model.lottorank.Rank;

public class CompareLotto {
    private HashMap<Integer, List<Lotto>> winLottos = new HashMap<>();

    public void compare(PurchaseLotto purchaseLotto, WinLotto winLotto) {
        purchaseLotto.compareLottos(winLotto, winLottos);
        removeTrash();
        System.out.println(winLottos);
    }

    public void compareBonusNumber(BonusNumber bonusNumber) {
        List<Lotto> winFive = winLottos.getOrDefault(5, new ArrayList<>());
        if (winFive.isEmpty()) {
            return;
        }

        List<Lotto> rankSecond = winFive.stream().filter(lotto -> lotto.containsBonusNumber(bonusNumber, lotto))
                .collect(Collectors.toList());
        winLottos.put(7, rankSecond);
        removeUpdatedLotto(rankSecond);
        System.out.println(winLottos);
    }

    private void removeUpdatedLotto(List<Lotto> rankSecond) {
        rankSecond.forEach(this::duplicate);
    }

    private void duplicate(Lotto lotto) {
        List<Lotto> winFive = winLottos.get(5);
        winFive.remove(lotto);
        winLottos.put(5, winFive);
    }

    private void removeTrash() {
        for (int i = 0; i < 3; i++) {
            winLottos.remove(i);
        }
    }

    public void getRevenue(TotalRevenue totalRevenue) {
        winLottos.forEach((k, v) -> {
            int price = Rank.price(k);
            totalRevenue.addRevenue((long) price * v.size());

        });
    }

    public int getFifth() {
        return winLottos.getOrDefault(3, new ArrayList<>()).size();
    }

    public int getFourth() {
        return winLottos.getOrDefault(4, new ArrayList<>()).size();
    }

    public int getThird() {
        return winLottos.getOrDefault(5, new ArrayList<>()).size();
    }

    public int getSecond() {
        return winLottos.getOrDefault(7, new ArrayList<>()).size();
    }

    public int getFirst() {
        return winLottos.getOrDefault(6, new ArrayList<>()).size();
    }
}
