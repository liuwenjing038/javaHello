package Day25;

public class 跳跃游戏 {
    public boolean canJump(int[] nums) {
        //看覆盖范围可不可以达到数组即可
        if (nums.length == 1) return true;
        int max = 0;
//        i 每次移动只能在 cover 的范围内移动，每移动一个元素，cover 得到该元素数值（新的覆盖范围）的补充，让 i 继续移动下去
        for (int i = 0; i <= max; i++) {
            max = Math.max(max, i + nums[i]);
            if (max >= nums.length - 1) return true;
        }
        return false;
    }
}
