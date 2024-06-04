package Day7;

//给你一个字符串 s ，请你反转字符串中单词的顺序 单词是由非空格字符组成的字符串。s 中使用至少一个空格将字符串中的单词分隔开。返回 单词 顺序颠倒且 单词 之间用单个空格连接的结果字符串。注意：输入字符串 s中可能会存在前导空格、尾随空格或者单词间的多个空格。返回的结果字符串中，单词间应当仅用单个空格分隔，且不包含任何额外的空格。



public class 翻转字符串中的每个单词 {
    public String reverseWords(String s) {
        //首先去除字符串中间与收尾的空格
        StringBuilder sb = removeSpace(s);
        //然后将字符串整个反转
        reverse(sb, 0, sb.length() - 1);
        //最后按照单词再次反转
        reverseEachWord(sb);
        return sb.toString();
    }

    public StringBuilder removeSpace(String s) {
        //首先移除收尾的空格
        int left = 0;
        int right = s.length() - 1;
        while (s.charAt(left) == ' ')left++;
        while (s.charAt(right) == ' ')right--;
        //去除中间的空格
        StringBuilder sb = new StringBuilder();
        while (left<=right){
            char c = s.charAt(left);
            if(c!=' ' || sb.charAt(sb.length()-1)!=' '){
                sb.append(c);
            }
            left++;
        }
        return sb;
    }

    public void reverse(StringBuilder sb, int left, int right){
        while (left<right){

            //注意翻转stringBuilder中的字符的写法
            char temp = sb.charAt(left);
            sb.setCharAt(left, sb.charAt(right));
            sb.setCharAt(right, temp);
            left++;
            right--;
        }
    }

    public void reverseEachWord(StringBuilder sb){
        int left = 0;
        int right = 1;
        int n = sb.length();
        while (left < n){
            //找到一个完整的单词
            while (right < n && sb.charAt(right) != ' '){
                right++;
            }
            reverse(sb, left, right - 1);

            //移动去寻找下一个单词
            left = right + 1;
            right = left + 1;
        }
    }
}