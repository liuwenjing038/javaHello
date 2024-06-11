package Day12;

import java.util.LinkedList;
import java.util.Queue;


//这里需要注意的一点是遍历到的第一个左右节点为空的节点就是最小深度
public class 二叉树的最小深度 {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;
        while (!queue.isEmpty()){
            depth++;
            int size = queue.size();
            while (size > 0 ){
                TreeNode node = queue.poll();
                if (node.left == null && node.right == null) return depth;
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
                size--;
            }
        }
        return depth;
    }
}
