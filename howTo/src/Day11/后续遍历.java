package Day11;

import java.util.ArrayList;
import java.util.List;

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
}
