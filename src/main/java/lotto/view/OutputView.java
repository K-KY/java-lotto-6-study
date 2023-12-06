package lotto.view;

import java.text.DecimalFormat;
import lotto.model.CompareLotto;

/*당첨 통계
---
3개 일치 (5,000원) - 1개
4개 일치 (50,000원) - 0개
5개 일치 (1,500,000원) - 0개
5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
6개 일치 (2,000,000,000원) - 0개
총 수익률은 62.5%입니다.
*/
public class OutputView {
    private static DecimalFormat decimalFormat = new DecimalFormat("###,###.##");

    public static void printResult(CompareLotto compareLotto) {
        System.out.println("3개 일치 (5,000원) - " + compareLotto.getFifth() + "개");
        System.out.println("4개 일치 (5,0000원) -" + compareLotto.getFourth() + "개");
        System.out.println("5개 일치 (1,500,000원) - " + compareLotto.getThird() + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + compareLotto.getSecond() + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + compareLotto.getFirst() + "개");
    }

    public static void printStatistics(long totalRevenue, int buy) {
        System.out.println("총 수익률은 " + decimalFormat.format((double)totalRevenue / buy * 100) + "%입니다.");
    }
}
