package Day2;

public class 有序数组的平方 {

//    给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。

    public int[] sortedSquares(int[] nums) {
        int [] result = new int[nums.length];
        int left = 0;
        int right = nums.length - 1;
        int index = nums.length - 1;
        while (left <= right){
            if (nums[left]*nums[left] > nums[right]*nums[right]){
                result[index--] = nums[left]*nums[left];
                left++;
            }else {
                result[index--] = nums[right]*nums[right];
                right--;
            }
        }
        return  result;
    }
}
