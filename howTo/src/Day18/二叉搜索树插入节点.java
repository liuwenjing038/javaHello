package Day18;

public class 二叉搜索树插入节点 {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        //如果找到空节点  说明找到了插入位置
        if (root == null) {
            return new TreeNode(val);
        }

        if (root.val > val) {
            root.left = insertIntoBST(root.left, val);
        } else {
            root.right = insertIntoBST(root.right, val);
        }
        return root;
    }
}
