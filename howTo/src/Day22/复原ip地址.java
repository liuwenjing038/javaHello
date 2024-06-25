package Day22;

import java.util.ArrayList;
import java.util.List;

public class 复原ip地址 {
    List<String> res = new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {
        if (s.length() > 12) return res;
        backtrack(s, 0, 0);
        return res;
    }
    //这里的count是记录逗号的数量
    public void backtrack(String s, int start, int count) {
        //终止条件
        if (count == 3){
            if (isValid(s, start, s.length() - 1)){
                res.add(s);
            }
            return;
        }
        //单层递归
        for (int i = start; i < s.length(); i++) {
            //如果符合 增逗号
            if (isValid(s, start, i)){
                s = s.substring(0, i + 1) + "." + s.substring(i + 1);
                count++;
                //需要注意这里是i+2  因为逗号也需要跳过
                backtrack(s, i + 2, count);
                //回溯
                count--;
                s = s.substring(0, i + 1) + s.substring(i + 2);
            }else {
                break;
            }
        }
    }

    public boolean isValid(String s, int start, int end) {
        if (start > end) return false;
        if (s.charAt(start) == '0' && start != end) return false;
        int num = 0;
        for (int i = start; i <= end; i++) {
            num = num * 10 + (s.charAt(i) - '0');
            if (num > 255) return false;
        }
        return true;
    }

}
