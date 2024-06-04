package Day6;

/*
* 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
*
*
* */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 三数之和 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            //剪枝  因为排序了 所以第一个大于0后面的就不用看了
            if(nums[i]>0) return result;
            //这里是对第一个数去重
            if(i>0 && nums[i]==nums[i-1]) continue;
            //左边指针
            int left = i+1;
            //右边指针
            int right = nums.length-1;
            while (left < right){
                int sum = nums[i] + nums[left] + nums[right];
                if (sum >0){
                    right--;
                }else if (sum<0){
                    left++;
                }else {
                    result.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    //然后对左右指针重复的去重
                    while (right > left && nums[right] == nums[right-1]) right--;
                    while (right > left && nums[left] == nums[left+1]) left ++;

                    //需要注意移动左右指针 因为当前已经找到了一组 应该移动左右指针
                    left++;
                    right--;
                }
            }
        }
        return result;
    }
}
