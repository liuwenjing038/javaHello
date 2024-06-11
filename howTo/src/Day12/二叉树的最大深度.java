package Day12;

import java.util.LinkedList;
import java.util.Queue;

public class 二叉树的最大深度 {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;
        while (!queue.isEmpty())
        {
            int size = queue.size();
            while (size > 0)
            {
                TreeNode node = queue.poll();
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
                size--;
            }
            depth++;
        }
        return depth;
    }
}
