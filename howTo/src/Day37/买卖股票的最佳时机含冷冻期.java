package Day37;

public class 买卖股票的最佳时机含冷冻期 {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int[][]dp = new int[prices.length][5];
        dp[0][0] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            //第i天持有股票 说明昨天可能持有股票 或者昨天是冷冻期 或者昨天就是卖出股票的状态
            dp[i][0] = Math.max(dp[i-1][0],Math.max(dp[i-1][3]-prices[i],dp[i-1][1]-prices[i]));
            //第i天不持有股票 说明以前就不持有 或前一天是冷冻状态  前一天是冷冻状态说明今天不能卖 因此不加prices[i]
            dp[i][1] = Math.max(dp[i-1][1],dp[i-1][3]);
            //今天就卖出股票 说明前一天是持有状态
            dp[i][2] = dp[i-1][0] + prices[i];
            //今天是冷冻期 说明昨天卖出了股票
            dp[i][3] = dp[i-1][2];

        }
        return Math.max(dp[prices.length-1][1],Math.max(dp[prices.length-1][2],dp[prices.length-1][3]));
    }

    public static void main(String[] args) {
        int[] prices = {1,2,3,0,2};
        System.out.println(new 买卖股票的最佳时机含冷冻期().maxProfit(prices));
    }
}
