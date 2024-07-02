package Day32;

import java.util.Arrays;

public class 目标和 {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = Arrays.stream(nums).sum();
        if (sum < Math.abs(target) || (sum + target) % 2 == 1) {
            return 0;
        }
        int CurrentSum = (sum + target) / 2;
        int[] dp = new int[CurrentSum + 1];
        //dp需要初始化为1 不放元素为一种操作  不然后面递推不出来
        dp[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = CurrentSum; j >= nums[i]; j--) {
                //其中dp[j]是放nums[i]后dp[j]的个数 dp[j-nums[i]]是不放nums[i]的个数
                dp[j] = dp[j] + dp[j - nums[i]];
            }
        }
        return dp[CurrentSum];
    }
}
