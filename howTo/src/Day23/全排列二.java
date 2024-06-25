package Day23;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//存在重复元素
public class 全排列二 {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    boolean used[];
    public List<List<Integer>> permuteUnique(int[] nums) {
        used = new boolean[nums.length];
        //去重问题一定要排序
        Arrays.sort(nums);
        backtrack(nums);
        return res;
    }

    public void backtrack(int[] nums){
        if (path.size() == nums.length){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            //树枝去重
            if (used[i]) continue;
            //剪枝去重
            if (i > 0 && nums[i] == nums[i-1] && !used[i-1]) continue;
            path.add(nums[i]);
            used[i] = true;
            backtrack(nums);
            path.remove(path.size()-1);
            used[i] = false;
        }
    }
}
