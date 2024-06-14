package Day15;
//给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。

public class 路径总和 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        return dfs(root, targetSum);
    }

    public boolean dfs(TreeNode root, int targetSum) {
        if (root == null) return false;
        if (root.left == null && root.right == null && root.val == targetSum) {
            return true;
        }
        //这里面包含了回溯的过程 targetSum - root.val
        return dfs(root.left, targetSum - root.val) || dfs(root.right, targetSum - root.val);
    }
    //回溯的写法
    public boolean hasPathSum2(TreeNode root, int targetSum) {
//        if (root == null) return false;
        if (root.left == null && root.right == null && targetSum == 0) {
            return true;
        }
        if (root.left == null && root.right == null) return false;
        if (root.left != null){
            targetSum -= root.left.val;
            if (hasPathSum2(root.left, targetSum)){
                return true;
            }
            targetSum += root.left.val;
        }
        if (root.right != null){
            targetSum -= root.right.val;
            if (hasPathSum2(root.right, targetSum)){
                return true;
            }
            targetSum += root.right.val;
        }
        return false;
    }
}
