package Day21;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。candidates 中的数字可以无限制重复被选取。
public class 组合总和 {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target){
        if (candidates == null) return res;
        //排序用来剪枝
        Arrays.sort(candidates);
        backTrack(candidates,target,0,0);
        return res;
    }

    public void backTrack(int[] candidates,int target,int sum,int start){
        if (sum == target){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            //剪枝 当前和加上数组元素大于目标值时，结束循环 因为数组是有序的
            //如果不排序的话这里应该是return来继续遍历
            if (sum + candidates[i] > target) break;
            path.add(candidates[i]);
            backTrack(candidates,target,sum+candidates[i],i);
            //回溯
            path.remove(path.size()-1);
        }
    }
}
