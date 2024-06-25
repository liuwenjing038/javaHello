package Day22;

import java.util.ArrayList;
import java.util.List;

public class 子集 {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        backtrack(nums, 0);
        return res;
    }
    public void backtrack(int[] nums, int start){
        //结果全收集
        res.add(new ArrayList<>(path));
        //终止条件  可以不写  因为全收集
        if (start == nums.length) return;
        for (int i = start; i < nums.length; i++) {
            path.add(nums[i]);
            backtrack(nums, i + 1);
            path.remove(path.size() - 1);
        }
    }
}
