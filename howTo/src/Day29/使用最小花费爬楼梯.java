package Day29;

public class 使用最小花费爬楼梯 {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length+1];
        //前两阶不需要花费
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i<= cost.length; i++) {
            //最小花费推导
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }
        return dp[cost.length];
    }
}
