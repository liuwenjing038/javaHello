package Day7;

public class 翻转字符串二 {
    /*
    * 给定一个字符串 s 和一个整数 k，从字符串开头算起, 每计数至 2k 个字符，就反转这 2k 个字符中的前 k 个字符。如果剩余字符少于 k 个，则将剩余字符全部反转。
如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样*/
    public String reverseStr(String s, int k) {
        char[] temp = s.toCharArray();
        for (int i = 0; i < temp.length; i+=2*k) {
            int start = i;
            //这里结尾够k个,就翻转这k个  不够k个则全部翻转
            int end = Math.min(i+k-1,temp.length-1);
            while (start<end){
                char cur = temp[start];
                temp[start] = temp[end];
                temp[end] = cur;
                start++;
                end--;
            }
        }
        return new String(temp);
    }
}
