package Day27;

import java.util.ArrayList;
import java.util.List;

public class 划分字母区间 {
    public List<Integer> partitionLabels(String S) {
        List<Integer> res = new ArrayList<>();
        int[] temp = new int[26];
        char[] chars = S.toCharArray();
        //统计每个字母的最远路径
        for (int i = 0; i < chars.length; i++) {
            temp[chars[i] - 'a'] = i;
        }
        int index = 0;
        //记录上一段截止的位置  因为长度计算方式为 last-start +1 因此这里是-1开始
        int last = -1;
        for (int i = 0; i < chars.length; i++) {
            index = Math.max(index, temp[chars[i] - 'a']);
            //i == index  说明遇到了一路遍历过来的最大值
            if (i == index) {
                res.add(i-last);
                last = i;
            }
        }
        return res;
    }
}
