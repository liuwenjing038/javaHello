package Day24;

public class 摆动序列 {
    public int wiggleMaxLength(int[] nums) {
        int up = 1,down = 1;
        //需要注意这里从1开始
        for(int i = 1;i< nums.length;i++){
            if(nums[i] > nums[i-1]){
                //只维护前一个摆动点
                up = down + 1;
            }else if(nums[i] < nums[i-1]){
                down = up + 1;
            }
            //这里有个隐藏的逻辑  遇到等于的就不处理
        }
        return Math.max(up,down);
    }
}
