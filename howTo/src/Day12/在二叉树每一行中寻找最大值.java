package Day12;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class 在二叉树每一行中寻找最大值 {
//    给定一棵二叉树的根节点 root ，请找出该二叉树中每一层的最大值。
    List<Integer> res = new ArrayList<>();
    public List<Integer> largestValues(TreeNode root) {
        levelOrder01(root);
        return res;
    }

    public void levelOrder01(TreeNode root){
        if(root == null) return;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            int Max = Integer.MIN_VALUE;
            while (size > 0){
                TreeNode node = queue.poll();
                Max = Math.max(node.val,Max);
                //等于1 说明走到了最后一个
                if (size == 1) res.add(Max);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
                size--;
            }
        }
    }
}
