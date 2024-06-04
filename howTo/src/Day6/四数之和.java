package Day6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，
// 使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组
//这道题需要注意的是target可能是一个负数,因此剪枝的时候需要注意不能直接num[i] >target就剪枝了
//因为比如[-4, -3, -2, -1]，target是-10 不能-4>-10就剪枝了
public class 四数之和 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>>result = new ArrayList<>();

        //先排序
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            //和三数之和一样先做剪枝
            if (nums[i] >0 && nums[i] > target) return  result;
            //一层去重
            if (i>0 && nums[i-1] == nums[i]) continue;
            for (int j = i+1; j < nums.length; j++) {
                //二层去重
                if (j>i+1 && nums[j-1] == nums[j]) continue;
                int left = j+1;
                int right = nums.length-1;
                while (left < right){
                    long sum = (long)nums[i]+nums[j]+nums[left]+nums[right];
                    if (sum>target){
                        right--;
                    }else if(sum<target){
                        left++;
                    }else {
                        result.add(Arrays.asList(nums[i],nums[j],nums[left],nums[right]));
                        //最后左右指标的去重
                        while (left<right && nums[right]==nums[right-1]) right--;
                        while (left<right && nums[left]==nums[left+1]) left++;
                        //找到后做指针移动
                        left++;
                        right--;
                    }
                }
            }
        }
        return result;
    }
}
