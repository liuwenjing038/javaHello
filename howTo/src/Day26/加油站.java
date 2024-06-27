package Day26;

public class 加油站 {
    //这题需要抽象出来一个剩余油量
    public int canCompleteCircuit(int[] gas, int[] cost) {
        //当前公里数
        int cur = 0;
        //总公里数
        int sum = 0;
        //第几个加油站
        int start = 0;
        for (int i = 0; i < gas.length; i++) {
            cur += gas[i] - cost[i];
            sum += gas[i] - cost[i];
            //如果当前公里数小于0，则从下一个加油站开始
            if (cur < 0){
                cur = 0;
                start = i + 1;
            }
        }
        //说明怎么都跑不到
        if (sum < 0) return -1;
        return start;
    }
}
