package Day2;

public class 长度最小的子数组 {
    public int minSubArrayLen(int target, int[] nums) {
        /*给定一个含有 n 个正整数的数组和一个正整数 target 。找出该数组中满足其总和大于等于 target 的长度最小的连续子数组
        [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0*/
        int left = 0;
        int result = Integer.MAX_VALUE; //这里也需要注意最小值时候需要使用最大值
        int sum = 0;
        for (int right = 0; right < nums.length; right++){
            sum += nums[right];
            while (sum >= target){
                result = Math.min(result,right-left+1);
                sum -= nums[left++];   //这一步需要注意left指标的移动
            }
        }

        return result == Integer.MAX_VALUE ? 0 : result;
    }
}
