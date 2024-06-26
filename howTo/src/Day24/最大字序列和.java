package Day24;

public class 最大字序列和 {
    public int maxSubArray(int[] nums) {
        int result = nums[0];
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            count += nums[i];
            if (count > result) {
                result = count;
            }
            //如果累加数组小于0 说明对后面没帮助了 置0
            if (count < 0) {
                count = 0;
            }
        }
        return result;
    }
}
