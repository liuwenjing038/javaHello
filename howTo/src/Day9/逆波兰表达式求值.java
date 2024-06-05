package Day9;

//输入: ["2", "1", "+", "3", " * "]
//输出: 9
//解释: 该算式转化为常见的中缀算术表达式为：((2 + 1) * 3) = 9

import java.util.Deque;
import java.util.LinkedList;

public class 逆波兰表达式求值 {

    //这里相当于二叉树的后序遍历
    public int evalRPN(String[] tokens) {
        Deque<Integer>stack=new LinkedList<>();
        for (String s : tokens) {
            if (s.equals("+")){
                stack.push(stack.pop()+stack.pop());
            }else if (s.equals("-")){
                stack.push(-stack.pop()+stack.pop());
            }else if (s.equals("*")){
                stack.push(stack.pop()*stack.pop());
            }else if (s.equals("/")){
                int a=stack.pop();
                int b=stack.pop();
                stack.push(b/a);
            }else {
                stack.push(Integer.parseInt(s));
            }
        }
        return stack.pop();
    }
}
