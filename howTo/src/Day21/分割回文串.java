package Day21;

import java.util.ArrayList;
import java.util.List;

public class 分割回文串 {
    List<List<String>> res = new ArrayList<>();
    List<String> path = new ArrayList<>();
    public List<List<String>> partition(String s) {
        backtrack(s,0);
        return res;
    }

    public void backtrack(String s,int startIndex){
        if (startIndex==s.length()){
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = startIndex; i < s.length(); i++) {
            if (isPalindrome(s,startIndex,i)){
                //这里需要注意是i+1
                path.add(s.substring(startIndex,i+1));
            }else {
                continue;
            }
            //单层递归
            backtrack(s,i+1);
            //回溯
            path.remove(path.size()-1);
        }
    }
    public boolean isPalindrome(String s,int start,int end){
        for (int i = start,j=end; i < j; i++,j--) {
            if (s.charAt(i) != s.charAt(j)){
                return false;
            }else {
                return true;
            }
        }
        return true;
    }
}
