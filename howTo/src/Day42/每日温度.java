package Day42;

import java.util.Deque;
import java.util.LinkedList;

public class 每日温度 {
    public int[] dailyTemperatures(int[] temperatures) {
        int[]res = new int[temperatures.length];
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < temperatures.length; i++) {
            //记录下标  使用下标来计数
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]){
                res[stack.peek()] = i - stack.peek();
                stack.pop();
            }
            stack.push(i);
        }
        return res;
    }
}
