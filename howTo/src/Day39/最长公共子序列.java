package Day39;

public class 最长公共子序列 {
    public int longestCommonSubsequence(String text1, String text2) {
        if (text1.length() == 0 || text2.length() == 0) return 0;
        char[]test3=text1.toCharArray();
        char[]test4=text2.toCharArray();
        int[][]dp=new int[test3.length+1][test4.length+1];
        for (int i = 1; i <= test3.length; i++) {
            for (int j = 1; j <= test4.length; j++) {
                if (test3[i-1]==test4[j-1])
                    dp[i][j]=dp[i-1][j-1]+1;
                else
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        return dp[test3.length][test4.length];
    }
}
