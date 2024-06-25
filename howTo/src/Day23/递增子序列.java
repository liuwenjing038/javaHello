package Day23;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class 递增子序列 {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> findSubsequences(int[] nums) {
        backtrack(nums, 0);
        return res;
    }

    public void backtrack(int[] nums, int start){
        //终止条件 因为是要满足递增 所以要满足长度大于1
        if(path.size() > 1){
            res.add(new ArrayList<>(path));
        }

        HashSet<Integer> set = new HashSet<>();
        for(int i = start; i < nums.length; i++){
            //剪枝
            if(!path.isEmpty() && nums[i] < path.get(path.size() - 1) || set.contains(nums[i])){
                continue;
            }else {
                set.add(nums[i]);
                path.add(nums[i]);
                backtrack(nums, i + 1);
                path.remove(path.size() - 1);
            }
        }
    }
}
