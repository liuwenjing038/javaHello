package Day40;

public class 不同的子序列 {
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();
        int[][] dp = new int[m + 1][n + 1];
        // 当t为空时，s的子序列有1种即为空
        for (int i = 0; i <= m; i++) {
            dp[i][0] = 1;
        }
        //当s为空时，t的子序列有0种 因为空字符不可能等于非空字符
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n ; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)){
                    //选这个i-1 以前有多少满足 + 不选这个i-1 以前有多少满足
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                }else {
                    //不选这个i-1 以前有多少满足
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[m][n];
    }
}
