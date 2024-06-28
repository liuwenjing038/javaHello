package Day30;

public class 不同路径 {
    public static int uniquePaths(int m, int n) {
        //dp数组
        int[][] dp = new int[m][n];
        //递推公式 有两种走法 dp[i][j] = dp[i-1][j] + dp[i][j-1]
        //初始化
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < n; j++){
            dp[0][j] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
}
