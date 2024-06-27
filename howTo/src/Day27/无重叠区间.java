package Day27;

import java.util.Arrays;

public class 无重叠区间 {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b) -> Integer.compare(a[0],b[0]));
        int temp = 1;
        for (int i = 1; i < intervals.length; i++) {
            // 如果当前区间的左边界小于前一个区间的右边界，则说明有重叠，则将当前区间的右边界和前一个区间的右边界取最小值
            if (intervals[i][0] < intervals[i-1][1]){
                intervals[i][1] = Math.min(intervals[i][1],intervals[i-1][1]);
            }else {
                temp++;
            }
        }
        // 返回区间个数减去非重叠区间个数
        return intervals.length - temp;
    }
}
