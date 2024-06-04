package Day7;


//字符串的右旋转操作是把字符串尾部的若干个字符转移到字符串的前面。给定一个字符串 s 和一个正整数 k，请编写一个函数，将字符串中的后面 k 个字符移到字符串的前面，实现字符串的右旋转操作。例如，对于输入字符串 "abcdefg" 和整数 2，函数应该将其转换为 "fgabcde"。
public class 右旋字符串 {
    public static void main(String[] args) {
        String s = "abcdefg";
        int k = 2;
        int len = s.length()-1;
        char[] s1 = s.toCharArray();
        //首先将字符串整个反转
        rightRotateString(s1, 0,len);
        //然后将前k个字符反转
        rightRotateString(s1, 0,k-1);
        //最后将剩余的字符串反转
        rightRotateString(s1, k,len);
        System.out.println(s1);
    }


    public static void rightRotateString(char[] str, int left,int right) {
        while (left <= right){
            char temp = str[left];
            str[left] = str[right];
            str[right] = temp;
            left++;
            right--;
        }
    }

}
