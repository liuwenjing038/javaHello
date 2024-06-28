package Day29;

public class 爬楼梯 {
    public int climbStairs(int n){
        if (n<=1) return n;
        //初始化数组
        int[]dp=new int[n+1];
        //递推公式 dp[i] = dp[i-1] + dp[i-2]
        //初始条件
        dp[1]=1;
        dp[2]=2;
        for (int i=3;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
}
