package Day19;

public class 将二叉搜索树转换为累加数 {
    int sum = 0;
    public TreeNode convertBST(TreeNode root){
        if (root == null) return null;
        //使用右中左的方式进行遍历
        convertBST(root.right);
        sum += root.val;
        root.val = sum;
        convertBST(root.left);
        return root;
    }
}
