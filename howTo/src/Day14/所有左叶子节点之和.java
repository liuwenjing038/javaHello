package Day14;

public class 所有左叶子节点之和 {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        //使用后序遍历
        int leftSum = sumOfLeftLeaves(root.left);
        int rightSum = sumOfLeftLeaves(root.right);

        int value = 0;
        //看中间节点,即中间节点是否存在有效的左叶子节点
        if (root.left!=null && root.left.left==null && root.left.right==null){
            value = root.left.val;
        }

        //这里的value的使用需要非常注意  也可以不定义value 直接使用leftSum  因为只计算出左叶子节点的和
        return leftSum + rightSum + value;
    }
}
