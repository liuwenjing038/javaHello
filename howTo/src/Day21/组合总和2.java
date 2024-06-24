package Day21;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
//candidates 中的每个数字在每个组合中只能使用一次。
//说明： 所有数字（包括目标数）都是正整数。解集不能包含重复的组合。
//输入: candidates = [10,1,2,7,6,1,5], target = 8,
public class 组合总和2 {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    boolean used[];
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates.length == 0) return res;
        used = new boolean[candidates.length];
        //这里排序一方面是为了剪枝  一方面是为了横向不重复处理
        Arrays.sort(candidates);
        backtrack(candidates, target, 0, 0);
        return res;
    }
    public void backtrack(int[] candidates, int target, int sum, int start){
        if (sum == target){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (sum + candidates[i] > target) break;
            //这里比较难理解 排序后横向虽然剪枝 但是还是可能遇到不用元素但值相同，这样在
            //这个数出现的第一个分支就会处理，不能吧这种情况排除掉 所以只有在第一次遍历的
            //前一次循环没有使用过才进行跳过不收集
            if (i > 0 && candidates[i] == candidates[i-1] && !used[i-1]) continue;
            path.add(candidates[i]);
            sum += candidates[i];
            used[i] = true;
            //这里不重复使用就用i+1
            backtrack(candidates, target,  sum, i + 1);
            //回溯
            path.remove(path.size() - 1);
            used[i] = false;
            sum -= candidates[i];
        }
    }
}
