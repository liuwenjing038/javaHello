package Day19;

public class 将有序数组转换为平衡二叉搜索树 {
    public TreeNode sortedArrayToBST(int[] nums) {
        //左闭右闭的区间
        return traversal(nums, 0, nums.length - 1);
    }
    public TreeNode traversal(int[] nums, int left, int right) {
        if (left > right) return null;
        int mid = left + (right - left >> 1);
        TreeNode root = new TreeNode(nums[mid]);
        //左闭右闭的区间 坚持循环不变量
        root.left = traversal(nums, left, mid - 1);
        root.right = traversal(nums, mid + 1, right);
        return root;
    }
}
