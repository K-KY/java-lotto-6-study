package lotto.model;

public class TotalRevenue {
    private long totalRevenue = 0;


    public void addRevenue(long price) {
        totalRevenue += price;
        System.out.println(totalRevenue);
    }

    public long getTotalRevenue() {
        return totalRevenue;
    }
}
