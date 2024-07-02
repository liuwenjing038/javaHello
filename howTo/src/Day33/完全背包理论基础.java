package Day33;

public class 完全背包理论基础 {
    public void testCompletePack(){
        int[] weight = {1, 3, 4};
        int[] value = {15, 20, 30};
        int bagWeight = 4;
        int[]dp = new int[bagWeight+1];
        for(int i = 0; i < weight.length; i++){
            //完全背包需要正序遍历来重复使用
            for (int j = weight[i]; j <= bagWeight; j++) {
                dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
            }
        }
        for (int maxValue : dp){
            System.out.println(maxValue + "   ");
        }
    }

    public static void main(String[] args) {
        完全背包理论基础 test = new 完全背包理论基础();
        test.testCompletePack();
    }
}
