package Day37;

public class 买卖股票的最佳时机四 {
    public int maxProfit(int k, int[] prices) {
        if (prices.length == 0) return 0;
        //分别是股票  买卖次数  是否持有
        int[][][]dp = new int[prices.length][k+1][2];
        for (int i = 0; i <=k ; i++) {
            dp[0][i][0] = -prices[0];
        }
        for (int i = 1; i < prices.length; i++) {
            for (int j = 1; j <= k; j++) {
                //我们把dp[0][0][0]作为一个初始状态，真正的买和卖是从dp[0][0][1]、dp[0][1][0]开始的，所以这里的一买、一卖，在第二维度中正好有一个+1的变化

                dp[i][j][0] = Math.max(dp[i-1][j][0],dp[i-1][j-1][1]-prices[i]);
                dp[i][j][1] = Math.max(dp[i-1][j][1],dp[i-1][j][0]+prices[i]);
            }
        }
        return dp[prices.length-1][k][1];
    }
}
