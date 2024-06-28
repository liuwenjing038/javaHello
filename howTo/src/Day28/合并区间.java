package Day28;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 合并区间 {
    public int[][] merge(int[][] intervals) {
        List<int[]> list = new ArrayList<>();
        //先排序
        Arrays.sort(intervals, (a, b) ->Integer.compare(a[0],b[0]));
        //把第一个区间放进去
        list.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            if (list.get(list.size()-1)[1] >= intervals[i][0]){
                list.get(list.size()-1)[1] = Math.max(list.get(list.size()-1)[1],intervals[i][1]);
            }else {
                //直接放进去 后续有重叠再更新
                list.add(intervals[i]);
            }
        }
        return list.toArray(new int[list.size()][]);
    }
}
