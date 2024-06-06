package Day11;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class 中序遍历 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        //第一步确认递归函数的参数和返回值
        inorder(root, res);
        return res;
    }

    public void inorder(TreeNode root, List<Integer> res) {
        //第二步确定终止条件
        if (root == null) return;

        //第三步确定单层递归的逻辑
        inorder(root.left, res);
        res.add(root.val);
        inorder(root.right, res);
    }

    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null)return res;
        Stack<TreeNode> stack = new Stack<>();
        //这里right为null的时候 因为stack不为空 因此可以继续循环
        while (root != null || !stack.isEmpty()){
            //先走到最左下角再开始记录值
            if (root != null){
                stack.push(root);
                root = root.left;
            }else {
                TreeNode node = stack.pop();
                res.add(node.val);
                root = node.right;
            }
        }
        return res;
    }
}