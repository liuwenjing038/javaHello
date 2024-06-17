package Day17;

public class 二叉树的最近公共祖先 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //如果遍历到了p 或者  q  直接返回(回溯)  这里包含p q 本身是祖先的情况
        if (root == null || root == p || root == q) return root;
        //回溯使用后序遍历
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        //在递归函数有返回值的情况下：如果要搜索一条边，递归函数返回值不为空的时候，立刻返回，如果搜索整个树，直接用一个变量left、right接住返回值，这个left、right后序还有逻辑处理的需要，也就是后序遍历中处理中间节点的逻辑（也是回溯）。
        if (left == null && right == null) return root;
        if (left != null && right != null) return root;
        return left != null ? left : right;
    }
}
