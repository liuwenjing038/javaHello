package Day8;

import java.util.Stack;

public class 用栈实现队列 {
    //
    Stack<Integer>stackIn;
    Stack<Integer>stackOut;
    public 用栈实现队列() {
        stackIn = new Stack<>();
        stackOut = new Stack<>();
    }

    public void push(int x) {
        //入栈的话直接push即可
        stackIn.push(x);
    }

    public int pop() {
        //出栈需要检查栈内是否为空，如果为空则将栈内元素全部push到栈内
        pushIfEmpty(stackIn,stackOut);
        return stackOut.pop();
    }

    public int peek() {
        pushIfEmpty(stackIn,stackOut);
        return stackOut.peek();
    }

    public boolean empty() {
        return stackIn.empty() && stackOut.empty();
    }

    //这里是关键的一步 如果出栈时out栈为空 则需要全部将in压入out
    public void pushIfEmpty(Stack<Integer>stackIn,Stack<Integer>stackOut){
        if (!stackOut.empty()) return;
        while (!stackIn.empty()){
            stackOut.push(stackIn.pop());
        }
    }
}
