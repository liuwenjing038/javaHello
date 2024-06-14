package Day15;


//深度优先遍历
//前序遍历（递归法，迭代法）
//中序遍历（递归法，迭代法）
//后序遍历（递归法，迭代法）
//广度优先遍历
//层次遍历（迭代法）
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(){};
    TreeNode(int val)
    {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right)
    {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
