package Day13;

import java.util.LinkedList;
import java.util.Queue;

public class 算完全二叉树的节点个数 {
    //首先用普通二叉树的递归
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        //使用后续遍历
        int left = countNodes(root.left);
        int right = countNodes(root.right);
        //最后再加上中间节点
        return left + right + 1;
    }

    //然后使用层序遍历
    public int countNodes2(TreeNode root) {
        if (root == null) return 0;
        int count = 0;
        Queue<TreeNode>queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            while (size > 0){
                TreeNode node = queue.poll();
                //这里的计数需要在进入下一层之前
                count++;
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
                size--;
            }
        }
        return count;
    }

    //最后针对完全二叉树的特性
    //满二叉树的结点数为：2^depth - 1
    public int countNodes3(TreeNode root) {
        if (root == null) return 0;
        TreeNode left = root.left;
        TreeNode right = root.right;
        int leftDepth = 0, rightDepth = 0;
        //先求左子树的深度
        while (left != null){
            left = left.left;
            leftDepth++;
        }
        //再求右子树的深度
        while (right != null){
            right = right.right;
            rightDepth++;
        }
        //如果相同则是满二叉树
        if (leftDepth == rightDepth){
            return (2<<leftDepth)-1;
        }
        //实际上也是后续遍历
        return countNodes3(root.left) + countNodes3(root.right) + 1;
    }
}
