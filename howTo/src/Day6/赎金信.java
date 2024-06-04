package Day6;

public class 赎金信 {
    /*
    * 给定一个赎金信 (ransom) 字符串和一个杂志(magazine)字符串，判断第一个字符串 ransom 能不能由第二个字符串 magazines 里面的字符构成。如果可以构成，返回 true ；否则返回 false。
题目说明：为了不暴露赎金信字迹，要从杂志上搜索各个需要的字母，组成单词来表达意思。杂志字符串中的每个字符只能在赎金信字符串中使用一次。
    * */

    public static boolean canConstruct(String ransomNote, String magazine) {
        //剪枝 如果第一个长度大于第二个  因为字符不可以重复 因此不存在第二个包含第一个
        if (ransomNote.length() > magazine.length()) return false;
        int[] temp = new int[26];

        //这里需要注意先遍历 magazine 因为magazine需要包含ransomNote
        for (char c : magazine.toCharArray()) {
            temp[c - 'a'] ++;
        }
        for (char c : ransomNote.toCharArray()) {
            temp[c - 'a'] --;
        }
        for (Integer c : temp) {
            //小于0说明后面有字母前面的字符串没有
            if (c < 0) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        System.out.println(canConstruct("aa", "aab"));
    }


}