package Day28;

public class 单调递增的数字 {
    public int monotoneIncreasingDigits(int N) {
        String s = String.valueOf(N);
        char[] chars = s.toCharArray();
        //这里的边界需要考虑单数的清况
        int index = chars.length;
        for (int i = chars.length - 2; i >= 0; i--) {
            if (chars[i] > chars[i + 1]) {
                chars[i]--;
                //这里需要注意从下一个开始
                index = i+1;
            }
        }
        for (int i = index; i < chars.length; i++) {
            chars[i] = '9';
        }
        return Integer.parseInt(new String(chars));
    }
}
