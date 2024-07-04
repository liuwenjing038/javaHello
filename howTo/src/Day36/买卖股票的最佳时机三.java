package Day36;

public class 买卖股票的最佳时机三 {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int[][]dp = new int[prices.length][5];
        //0持有 1不持有 2持有 3不持有
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        dp[0][2] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            //若是当天发生的交易 则用前一天的钱减去当前价格
            dp[i][0] = Math.max(dp[i - 1][0], - prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
            dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1] - prices[i]);
            dp[i][3] = Math.max(dp[i - 1][3], dp[i - 1][2] + prices[i]);
        }
        return dp[prices.length - 1][3];
    }
}
