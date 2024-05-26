package Day1;

public class 移除元素 {
    public int removeElement(int[] nums, int val) {
        int slowIndex = 0;
        for (int fastIndex = 0; fastIndex < nums.length; fastIndex++){
            if (nums[fastIndex]!=val){
                nums[fastIndex] = nums[slowIndex];
                slowIndex++;
            }
        }
        return  slowIndex;
    }
}
