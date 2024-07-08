package Day39;

public class 判断子序列 {
    public boolean isSubsequence(String s, String t) {

        //因为要把第一行第一列空出来
//        dp[i][j] 表示以下标i-1为结尾的字符串s，和以下标j-1为结尾的字符串t，相同子序列的长度为dp[i][j]。
        int[][]dp=new int[s.length()+1][t.length()+1];
        char[]charS = s.toCharArray();
        char[]charT = t.toCharArray();
        for(int i=1;i<=s.length();i++) {
            for(int j=1;j<=t.length();j++){
                if (charS[i-1]==charT[j-1]){
                    dp[i][j]=dp[i-1][j-1]+1;
                }else {
                    //不相等一定是t删除
                    dp[i][j]=dp[i][j-1];
                }
            }
        }
        return dp[s.length()][t.length()]==s.length();
    }
}
