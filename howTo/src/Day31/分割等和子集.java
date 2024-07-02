package Day31;

import java.util.Arrays;

public class 分割等和子集 {
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 != 0) {
            return false;
        }
        int target =  sum / 2;
        int[] dp = new int[target + 1];
        //先遍历物品后遍历重量
        for (int i = 0; i < nums.length; i++) {
            for (int j = target; j >= nums[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - nums[i]] +nums[i]);
            }
        }
        return dp[target] == target;
    }
}
