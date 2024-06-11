package Day11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class 后续遍历 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        //第一步确认递归函数的参数和返回值
        postorder(root,res);
        return res;
    }
    public void postorder(TreeNode root,List<Integer> res){
        //第二步确定终止条件
        if (root == null) return;

        //第三步确定单层递归的逻辑
        postorder(root.left,res);
        postorder(root.right,res);
        res.add(root.val);
    }

    //后序遍历左右中 入栈顺序中左右 出栈顺序中右左  最后反转
    public List<Integer> postorderTraversal1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            res.add(node.val);
            if (node.left != null) stack.push(node.left);
            if (node.right != null) stack.push(node.right);
        }
        Collections.reverse(res);
        return res;
    }
}
