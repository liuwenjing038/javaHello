package Day5;

import java.util.HashMap;

public class 有效的字母异位词 {
    /*
    * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。*/
//    使用数组来做哈希的题目，是因为题目都限制了数值的大小。


    public boolean isAnagram(String s, String t) {
        //26个字母因此最大26
        int[] res = new int[26];
        for (int i = 0; i < s.length(); i++) {
            //这里需要将 s[i] - ‘a’ 所在的元素做+1 操作即可，并不需要记住字符a的ASCII，只要求出一个相对数值就可以了
            //需要注意这里的s.charAt(i)-'a'是下标
            res[s.charAt(i)-'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            res[t.charAt(i)-'a']--;
        }
        for (int i = 0; i < res.length; i++) {
            if (res[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
