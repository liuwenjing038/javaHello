package Day27;

import java.util.Arrays;

public class 用最少数量的剑引爆气球 {
    public int findMinArrowShots(int[][] points) {
        //首先按做边界排序
//        Arrays.sort(points,(a,b) -> a[0] - b[0]);
        //这种排序更加安全  数据范围很大 使用
        Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0]));
        //最少需要一支箭
        int result = 1;
        for (int i = 1; i < points.length; i++) {
            //如果当前气球的左边界大于前一个气球的右边界，则两个气球不挨着 需要多一只箭来射
            if (points[i][0] > points[i - 1][1]) {
                result++;
            } else {
                //否则，两个气球重叠 需要更新重叠部分的最小边界
                points[i][1] = Math.min(points[i][1], points[i - 1][1]);
            }
        }
        return result;
    }
}
