package Day10;

import java.util.Deque;
import java.util.LinkedList;

//维护一个单调队列解题
public class 滑动窗口的最大值 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length==1) return nums;
        int len = nums.length-k+1;
        int[]res = new int[len];
        myQueue myQueue = new myQueue();
        int num=0;

        //先从前K个选出来一个最大值
        for (int i = 0; i < k; i++) {
            myQueue.add(nums[i]);
        }
        res[num++] = myQueue.peek();
//        然后每走一步更新一个值
        for (int i = k; i < nums.length; i++) {
            myQueue.poll(nums[i-k]);
            myQueue.add(nums[i]);
            res[num++] = myQueue.peek();
        }
        return res;
    }


    class myQueue {
        Deque<Integer> deque = new LinkedList<>();

        //这里的poll需要注意只有队首的元素要出栈时才处理  因为其它元素在push时候就处理了
        void poll(int x){
            if(!deque.isEmpty() && deque.peek() == x){
                deque.poll();
            }
        }

        void add(int x){
            while (!deque.isEmpty() && deque.peekLast() < x){
                deque.removeLast();
            }
            deque.add(x);
        }
        int peek(){
            return deque.peek();
        }
    }
}
