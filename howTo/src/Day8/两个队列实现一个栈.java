package Day8;

import java.util.ArrayDeque;
import java.util.Queue;

public class 两个队列实现一个栈 {
    Queue<Integer> queue1;
    Queue<Integer> queue2;
    public 两个队列实现一个栈() {
        queue1 = new ArrayDeque<>();
        queue2 = new ArrayDeque<>();
    }

    public void push(int x) {
        //先将队列1中的元素全部移到队列2中
        //注意这里不需要用size来计数
        while (queue1.size() > 0){
            queue2.add(queue1.poll());
        }
        //将x放入队列1
        queue1.add(x);
        while (queue2.size() > 0){
            queue1.add(queue2.poll());
        }
    }


    public int pop() {
        return queue1.poll();
    }

    public int top() {
        return queue1.peek();
    }

    public boolean empty() {
        return queue1.size() == 0;
    }
}
