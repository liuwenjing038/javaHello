import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class 有效的队列 {
//    给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
//    有效字符串需满足：
//    左括号必须用相同类型的右括号闭合。
//    左括号必须以正确的顺序闭合。
//    注意空字符串可被认为是有效字符串。
    public boolean isValid(String s) {
        //这里直接使用Stack也是可以的 后续需要考虑下为什么使用Deque
        Deque<Character> stack = new LinkedList<>();
        //这里需要注意使用技巧 左括号就压入右括号,方便后面比较
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '('){
                stack.push(')');
            }else if (s.charAt(i) == '{'){
                stack.push('}');
            }else if (s.charAt(i) == '['){
                stack.push(']');
//            这里的判断有两种情况,第一种是括号不相等了,第二种是没有左括号就直接来右括号了  即为空栈的情况
            }else if(stack.isEmpty() || s.charAt(i) != stack.peek()){
                return false;
            }else {
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
