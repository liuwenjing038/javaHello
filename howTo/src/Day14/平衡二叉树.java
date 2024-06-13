package Day14;

public class 平衡二叉树 {
    public boolean isBalanced(TreeNode root) {
        return getHeight(root) != -1;
    }
    public int getHeight(TreeNode root) {
        if(root == null) return 0;
        //使用后续遍历 判断子树是否是平衡二叉树，不是的话就返回-1
        int left = getHeight(root.left);
        if(left == -1) return -1;
        int right = getHeight(root.right);
        if(right == -1) return -1;
        //判断是不是平衡二叉树  看左右子树的差值是不是大于1
        if (Math.abs(left - right) > 1 ) return -1;
        //是平衡二叉树则返回左右子树高的
        return Math.max(left, right) + 1;
    }
}
