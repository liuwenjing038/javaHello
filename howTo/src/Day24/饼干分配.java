package Day24;

import java.util.Arrays;

public class 饼干分配 {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int result = 0;
        int count = 0;
        //这里需要确认胃口数组不越界
        for (int i = 0; i < s.length && count < g.length; i++) {
            if (s[i] >= g[count]){
                result++;
                count++;
            }
        }
        return result;
    }
}
