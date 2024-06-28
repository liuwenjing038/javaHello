package Day29;

public class 斐波那契数列 {
    public int fib(int n) {
        if (n <= 1) return n;
        //数据初始化
        int dp[] = new int[n + 1];
        //递推公式 dp[i] = dp[i-1] + dp[i-2]
        //初始条件
        dp[0] = 0;
        dp[1] = 1;
        //确定遍历顺序 从头往尾
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
