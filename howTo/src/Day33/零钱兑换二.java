package Day33;

public class 零钱兑换二 {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        // 初始化
        dp[0] = 1;
        //先遍历硬币为组合数  先遍历背包为排列数
        for (int i = 0; i < coins.length; i++) {
            //完全背包需要正序遍历来重复加入
            for (int j = coins[i]; j <= amount ; j++) {
                dp[j] = dp[j] + dp[j - coins[i]];
            }
        }
        return dp[amount];
    }
}
