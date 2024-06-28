package Day30;

public class 不同路径二 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        //初始化dp
        int[][] dp = new int[m][n];
        //递推公式  if(obstacleGrid==0) dp[i][j] = dp[i-1][j] + dp[i][j-1] else dp[i][j] = 0;
        //需要注意障碍物遇到后  后面就无法到达  遍历也终止了
        for (int i = 0; i < m && obstacleGrid[i][0] == 0; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < n && obstacleGrid[0][j] == 0; j++) {
            dp[0][j] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                //这里其实障碍物后的格子也判断了 但因为初始化时候为0 所以没影响
                if (obstacleGrid[i][j] == 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}
