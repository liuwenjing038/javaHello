package Day12;

public class 对称二叉树 {

    public boolean isSymmetric1(TreeNode root) {
        return isMirror(root.left,root.right);
    }

    public boolean isMirror(TreeNode left,TreeNode right){
        if (left == null && right != null){
            return false;
        }else if (left != null && right == null){
            return false;
        }else if (left == null && right == null){
            return true;
        }else if (left.val != right.val){
            return false;
        }

        //当左右节点都不为0且相等时 先判断内圈是否对称
        boolean in = isMirror(left.right,right.left);
        //判断外圈是否对称
        boolean out = isMirror(left.left,right.right);
        return in && out;
    }
}
