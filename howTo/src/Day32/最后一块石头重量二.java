package Day32;

import java.util.Arrays;

public class 最后一块石头重量二 {
    public int lastStoneWeightII(int[] stones) {
        int target = Arrays.stream(stones).sum()/2;
        int[] dp = new int[target+1];
        for (int i = 0; i < stones.length; i++) {
            for (int j = target; j >= stones[i]; j--) {
                dp[j] = Math.max(dp[j],dp[j-stones[i]]+stones[i]);
            }
        }
        return Arrays.stream(stones).sum()-2*dp[target];
    }
}
