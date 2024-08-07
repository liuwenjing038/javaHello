package Day42;

import java.util.Arrays;
import java.util.Stack;

public class 下一个更大的元素二 {
    public int[] nextGreaterElements(int[] nums) {
        int[]res=new int[nums.length];
        Arrays.fill(res,-1);
        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<nums.length*2;i++){
            //需要注意这里更新的是i%nums.length
            while(!stack.isEmpty()&&nums[stack.peek()]<nums[i%nums.length]){
                res[stack.pop()]=nums[i%nums.length];
            }
            stack.push(i%nums.length);
        }
        return res;
    }
}
