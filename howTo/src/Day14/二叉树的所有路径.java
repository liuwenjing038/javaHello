package Day14;

import java.util.ArrayList;
import java.util.List;

public class 二叉树的所有路径 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) return res;
        List<Integer>temp = new ArrayList<>();
        dfs(root, temp, res);
        return res;
    }
    public void dfs(TreeNode root, List<Integer> temp, List<String> res){
       //使用前序遍历来搜集所有路径
       temp.add(root.val);
       StringBuilder sb = new StringBuilder();
       //遍历到叶子节点的时候，将路径添加到结果中
        if(root.left == null && root.right == null){
            for (int i = 0; i < temp.size()-1; i++) {
                sb.append(temp.get(i)).append("->");
            }
            //添加最后的叶子节点
            sb.append(temp.get(temp.size()-1));
            //添加到结果中
            res.add(sb.toString());
            return;
        }

        //然后遍历所有子树
        if(root.left != null){
            dfs(root.left, temp, res);
            //这里是回溯的过程，每次递归都需要进行一次回溯
            temp.remove(temp.size()-1);
        }
        if(root.right != null){
            dfs(root.right, temp, res);
            //这里是回溯的过程，每次递归都需要进行一次回溯
            temp.remove(temp.size()-1);
        }
    }
}
