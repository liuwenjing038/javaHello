package Day36;

public class 买卖股票的最佳时机二 {
    public int maxProfit(int[] prices) {
        int[][]dp=new int[prices.length][2];
        dp[0][0]=-prices[0];
        // dp[i][0]表示第i天持有股票的最大利润
        // dp[i][1]表示第i天不持有股票的最大利润
        for(int i=1;i<prices.length;i++){
            //这里股票只允许买卖一次  因此直接-prices[i]
            dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]-prices[i]);
            dp[i][1]=Math.max(dp[i-1][1],dp[i-1][0]+prices[i]);
        }
        return dp[prices.length-1][1];
    }
}
