package Day31;

public class 背包理论基础 {
    public  void testWeightBagProblem(int[] weight, int[] value, int bagSize){
        int[][] dp = new int[weight.length][bagSize+1];
        //初始化能放进第一个物品及以后背包价值为第一个背包价值
        for (int i = weight[0]; i <= bagSize; i++) {
            dp[0][i] = value[0];
        }
        for (int i = 1; i < weight.length; i++) {
            for (int j = 1; j <= bagSize; j++) {
                //背包放不下
                if (j < weight[i]) {
                    dp[i][j] = dp[i-1][j];
                }else {
                    //背包放的下 取放与不放的最大值
                    dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-weight[i]]+value[i]);
                }
            }
        }
    }
}
