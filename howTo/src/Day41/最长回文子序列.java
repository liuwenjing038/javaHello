package Day41;

public class 最长回文子序列 {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][]dp = new int[n][n];
        //只有一个字母的话一定是回文的 算一个
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }
        for (int i = n - 1; i >= 0; i--) {
            //从i +1 开始
            for (int j = i + 1; j < n; j++) {
                //如果相等 说明这两个字母是回文 需要查看子串是否回文 不是的话就是0 + 2
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                //如果不相等 那么就看取左边的字母或右边字母  然后得出的回文子串中长的
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][n - 1];
    }
}
