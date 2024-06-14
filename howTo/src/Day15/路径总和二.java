package Day15;

import java.util.ArrayList;
import java.util.List;



//寻租所有满足的路径
public class 路径总和二 {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if(root == null) return res;
        dfs(root,targetSum);
        return res;
    }
    public void dfs(TreeNode root,int targetSum){
        if(root == null) return;
        path.add(root.val);
       if (root.left == null && root.right == null && root.val == targetSum){
           //这里需要注意path是引用类型 需要有个浅拷贝保证path值不被后序节点修改
           res.add(new ArrayList<>(path));
       }
       //这包含回溯
       dfs(root.left,targetSum-root.val);
       dfs(root.right,targetSum-root.val);
       //路径也需要回溯
       path.remove(path.size()-1);
    }
}
