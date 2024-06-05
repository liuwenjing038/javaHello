package Day11;

import java.util.ArrayList;
import java.util.List;

public class 中序遍历 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        //第一步确认递归函数的参数和返回值
        inorder(root,res);
        return res;
    }
    public void inorder(TreeNode root,List<Integer> res){
        //第二步确定终止条件
        if (root == null) return;

        //第三步确定单层递归的逻辑
        inorder(root.left,res);
        res.add(root.val);
        inorder(root.right,res);
    }
}
