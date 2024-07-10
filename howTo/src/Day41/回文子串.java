package Day41;

public class 回文子串 {
    public int countSubstrings(String s) {
        char[] chars = s.toCharArray();
        int len = chars.length;
        boolean[][] dp = new boolean[len][len];
        int res = 0;
        for (int i = len-1; i >=0 ; i--) {
            //需要注意这里从i开始遍历  因为dp数组的定义是看[i+1,j-i]的子区间是否是回文
            for (int j = i; j <len ; j++) {
                if (chars[i] == chars[j]){
                    //当字符串只有一个字母或两个字母时
                    if (j - i <= 1){
                        dp[i][j] = true;
                        res++;
                    //当字符串非一个字母时 判断子串是否为回文
                    }else if (dp[i+1][j-1]){
                        dp[i][j] = true;
                        res++;
                    }
                }
            }
        }
        return res;
    }
}
