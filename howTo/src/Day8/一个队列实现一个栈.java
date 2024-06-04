package Day8;

import java.util.ArrayDeque;
import java.util.Deque;



// Deque 接口继承了 Queue 接口
// 所以 Queue 中的 add、poll、peek等效于 Deque 中的 addLast、pollFirst、peekFirst
public class 一个队列实现一个栈 {
    Deque<Integer> queue = new ArrayDeque<>();
    public 一个队列实现一个栈() {

    }

    public void push(int x) {
        queue.addLast(x);
    }

    //注意需要留一个让返回
    public int pop() {
        int size = queue.size();
        while (size > 1){
            queue.addLast(queue.pollFirst());
            size--;
        }
        return queue.pollFirst();
    }

    public int top() {
        return queue.peekLast();
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}
