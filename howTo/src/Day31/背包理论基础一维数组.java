package Day31;

public class 背包理论基础一维数组 {
    public static void testWeightBagProblem(int[] weight, int[] value, int bagWeight){
        //定义dp数组：dp[j]表示背包容量为j时，能获得的最大价值
        int[] dp = new int[bagWeight+1];
        //数组初始化为0即可
        //必须先遍历物品再遍历背包重量
        for(int i = 0; i < weight.length; i++){
            //这里需要倒着遍历 不能让上一个背包重量状态影响下一个
            //遍历到背包能放下截止
            for (int j = bagWeight; j >= weight[i]; j--) {
                dp[j] = Math.max(dp[j],dp[j-weight[i]]+value[i]);
            }
        }
    }
}
