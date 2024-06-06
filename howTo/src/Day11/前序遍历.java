package Day11;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class 前序遍历 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        //第一步确认递归函数的参数和返回值
        preorder(root, res);
        return res;
    }

    public void preorder(TreeNode root, List<Integer> res) {
        //第二步确定终止条件
        if (root == null) return;

        //第三步确定单层递归的逻辑
        res.add(root.val);
        preorder(root.left, res);
        preorder(root.right, res);
    }

    //入栈顺序中-右-左  出栈顺序中-左-右
    public List<Integer> preorderTraversal1(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode>stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            res.add(node.val);
            //这里需要注意因为是使用栈所以需要先放入右边
            if (node.right != null){
                stack.push(node.right);
            }
            if (node.left != null){
                stack.push(node.left);
            }
        }
        return res;
    }
}