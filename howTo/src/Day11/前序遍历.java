package Day11;

import java.util.ArrayList;
import java.util.List;

public class 前序遍历 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        //第一步确认递归函数的参数和返回值
        preorder(root,res);
        return res;
    }
    public void preorder(TreeNode root,List<Integer> res){
        //第二步确定终止条件
        if (root == null) return;

        //第三步确定单层递归的逻辑
        res.add(root.val);
        preorder(root.left,res);
        preorder(root.right,res);
    }
}
