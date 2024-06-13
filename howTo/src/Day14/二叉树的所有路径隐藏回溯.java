package Day14;

import java.util.ArrayList;
import java.util.List;

public class 二叉树的所有路径隐藏回溯 {
    List<String> res = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) return res;
        dfs(root, "");
        return res;
    }
    public void dfs(TreeNode root, String path) {
        if (root == null) return;
        if (root.left == null && root.right == null){
            res.add(new StringBuilder(path).append(root.val).toString());
        }
        //回溯的步骤隐藏在这一步 因为递归的过程中没有加 -> 因此不需要做回溯
        String tmp = new StringBuilder(path).append(root.val).append("->").toString();
        dfs(root.left, tmp);
        dfs(root.right, tmp);
    }
    public void dfs2(TreeNode root, String path) {
        path += root.val;
        if (root.left == null && root.right == null){
            res.add(path);
            return;
        }
        if (root.left != null){
            path += "->";
            dfs2(root.left, path);
            //这里是回溯 去掉的两个为 ->
            path = path.substring(0, path.length() - 2);
        }
        if (root.right != null){
            path += "->";
            dfs2(root.right, path);
            path = path.substring(0, path.length() - 2);
        }
    }
}
