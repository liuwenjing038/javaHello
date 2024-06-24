package Day19;

public class 修剪二叉搜索树 {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if(root == null) return null;
        //先处理区间外的值，注意不能直接返回null 因为会忽略掉另一半的树
        if(root.val < low) return trimBST(root.right, low, high);
        if(root.val > high) return trimBST(root.left, low, high);
        //处理区间内的值  这里必须用返回值接 不然会断开连接
        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);
        return root;
    }
}
