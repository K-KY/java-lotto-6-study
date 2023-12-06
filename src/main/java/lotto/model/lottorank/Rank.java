package lotto.model.lottorank;

import java.util.List;

public enum Rank {
    RANK_FIRST(2_000_000_000, 6),
    RANK_SECOND(30_000_000, 7),
    RANK_THIRD(1_500_000, 5),
    RANK_FOURTH(50_000, 4),
    RANK_FIFTH(5_000, 3);

    private int price;
    private int rankID;

    Rank(int price, int rankID) {
        this.price = price;
        this.rankID = rankID;
    }

    public static int price(int rankID) {
        List<Rank> ranks = List.of(values());
        for (int i = 0; i < ranks.size(); i++) {
            if (ranks.get(i).rankID == rankID) {
                return ranks.get(i).price;
            }
        }
        return 0;
    }


}
