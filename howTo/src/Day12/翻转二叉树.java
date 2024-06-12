package Day12;

import java.util.LinkedList;
import java.util.Queue;

public class 翻转二叉树 {
    //DFS
    //需要注意的是可以使用前后序遍历  中序遍历因为先交换了 所以不能使用
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return null;
        swapTree(root);
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
    
    //使用层序遍历BFS
    public TreeNode invertTree1(TreeNode root) {
        if(root == null) return null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            while (size > 0){
                TreeNode node = queue.poll();
                swapTree(node);
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
                size--;
            }
        }
        return root;
    }

    public void swapTree(TreeNode root)
    {
        if(root == null) return;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }
}
