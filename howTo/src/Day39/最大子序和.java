package Day39;

public class 最大子序和 {
    public static int maxSubArray(int[] nums) {
        if (nums.length == 0) return 0;
        int[]dp = new int[nums.length];
        dp[0] = nums[0];
        int res = dp[0];
        for (int i = 1; i < nums.length; i++) {
            //选当前节点或者以当前节点为起点的最大子数组和
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
