package Day42;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;

public class 下一个更大的元素一 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[]res = new int[nums1.length];
        //因为结果不存在要返回-1
        Arrays.fill(res,-1);
        HashMap<Integer,Integer> map = new HashMap<>();
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i = 0;i<nums1.length;i++){
            map.put(nums1[i],i);
        }
        for(int i = 0;i<nums2.length;i++){
            //这个栈里存的是nums2中的元素
            while (!stack.isEmpty()&&nums2[i]>stack.peek()){
                int num = stack.pop();
                if(map.containsKey(num)){
                    res[map.get(num)] = nums2[i];
                }
            }
            stack.push(nums2[i]);
        }
        return res;
    }
}
