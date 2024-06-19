package Day18;

public class 删除二叉搜索树中的节点 {
    public TreeNode deleteNode(TreeNode root, int key) {
        //如果没有找到  返回
        if (root == null) return null;
        if (root.val == key){
            if (root.left == null){
                return root.right;
            }else if (root.right == null){
                return root.left;
            }else {
                //找到右子树最小的节点
                TreeNode node = root.right;
                while (node.left != null){
                    node = node.left;
                }
                //将root左子树放到node的左子树
                node.left = root.left;
                root = root.right;
                return root;
            }
        }
        //单条链路判断 使用返回值进行递归
        if (root.val > key) root.left = deleteNode(root.left, key);
        if (root.val < key) root.right = deleteNode(root.right, key);
        return root;
    }
}
