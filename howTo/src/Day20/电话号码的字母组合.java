package Day20;

import java.util.ArrayList;
import java.util.List;

public class 电话号码的字母组合 {
    List<String> res = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) return res;
        String[] numString = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        backTrack(digits, numString, 0);
        return res;
    }

    StringBuilder path = new StringBuilder();
    public void backTrack(String digits, String[] numString, int index) {
        //说明遍历到了叶子节点 收集结果
        if (index == digits.length()){
            res.add(path.toString());
            return;
        }
        String letters = numString[digits.charAt(index) - '0'];
        for (int i = 0; i < letters.length(); i++) {
            path.append(letters.charAt(i));
            backTrack(digits, numString, index+1);
            //回溯  这里要注意删除的是最后一个字符
            path.deleteCharAt(path.length()-1);
        }
    }
}
