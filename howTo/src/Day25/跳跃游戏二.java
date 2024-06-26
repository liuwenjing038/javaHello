package Day25;
//最少几步可以调到终点
public class 跳跃游戏二 {
    public int jump(int[] nums) {
        if (nums.length == 1) return 0;
        //第一步范围
        int curDistance = 0;
        //下一步范围
        int nextDistance = 0;
        int step = 0;
        for (int i = 0; i <= curDistance; i++) {
            nextDistance = Math.max(nums[i]+i,nextDistance);
            //如果这一步走到范围末尾了 更新覆盖范围的最远下标
            if (i == curDistance){
                curDistance = nextDistance;
                step++;
                if (curDistance >= nums.length-1) return step;
            }
        }
        return step;
    }
}
