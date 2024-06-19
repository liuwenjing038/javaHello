package Day18;

public class 二叉搜索树的最近公共祖先 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //根据二叉搜索树的性质，如果p和q的值都大于root的值，则p和q都在root的右子树中，反之，如果p和q的值都小于root的值，则p和q都在root的左子树中，
        if (root.val > p.val && root.val > q.val) return lowestCommonAncestor(root.left, p, q);
        if (root.val < p.val && root.val < q.val) return lowestCommonAncestor(root.right, p, q);
        //反之，则p和q分别在root的左子树和右子树中，则root就是最近公共祖先。
        return root;
    }
}
