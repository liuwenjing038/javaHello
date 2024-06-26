package Day25;

public class 买卖股票的最佳时机2 {
    public int maxProfit(int[] prices) {
        int profit = 0;
        //贪心收集每天的正利润即可  第二天才可以产生利润
        for (int i = 1; i < prices.length; i++) {
            profit += Math.max(prices[i] - prices[i - 1], 0);
        }
        return profit;
    }
}
