package Day35;

public class 打家劫舍三 {
    public int rob(TreeNode root) {
        int[] res = robSub(root);
        return Math.max(res[0], res[1]);
    }

    public int[] robSub(TreeNode root) {
        int[] res = new int[2];
        if (root == null) {
            return res;
        }
        //后续遍历
        int[] left = robSub(root.left);
        int[] right = robSub(root.right);
        //偷当前节点
        res[0] = root.val + left[1] + right[1];
        //不偷当前节点  偷左右节点 左右节点需要分别取偷与不偷的较大值
        res[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        return res;
    }
}
