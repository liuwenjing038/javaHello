package Day26;

import java.util.Arrays;
import java.util.LinkedList;

public class 根据身高重建队列 {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> {if (a[0] == b[0]) {
            //如果高度相同，按照k值排序
            return a[1] - b[1];
        } else {
            //按照身高排序
            return b[0] - a[0];
        }});
        LinkedList<int[]> res = new LinkedList<>();
        //按照k值插入
        for (int[]p : people) {
            res.add(p[1], p);  //p1为第几个位置 p为值
        }
        return res.toArray(new int[people.length][]);
    }
}
