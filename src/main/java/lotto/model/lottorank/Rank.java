package lotto.model.lottorank;

public enum Rank {
    RANK_FIRST(2_000_000_000),
    RANK_SECOND(30_000_000),
    RANK_THIRD(1_500_000),
    RANK_FOURTH(50_000),
    RANK_FIFTH(5_000);

    private int price;

    Rank(int price) {
        this.price = price;
    }
}
