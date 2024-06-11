package Day12;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class 二叉树的层平均值 {
    List<Double> res = new ArrayList<>();
    public List<Double> averageOfLevels(TreeNode root) {
        levelOrder(root);
        return res;
    }
    public void levelOrder(TreeNode root){
        if (root == null) return;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            //这里需要暂存一下size 用来记录个数
            int temp = size;
            Double sum = 0.0;
            while (size > 0){
                TreeNode node = queue.poll();
                sum += node.val;
                //这里需要走到最后再计算平均值 否则[3,9,20,null,null,15,7] 会输出3 9 29/2 15 22/2
                if(size == 1) res.add(sum/temp);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
                size--;
            }
        }
    }
}
