package Day15;

import java.util.LinkedList;
import java.util.Queue;

public class 找树左下角的值 {
    public int findBottomLeftValue(TreeNode root) {
        if(root == null) return 0;
        int res = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            int temp = size;
            while (size > 0){
                TreeNode node = queue.poll();
                //需要注意这里记录的是左下角  队列先进先出 因此需要用一个变量记录
                if(size == temp) res = node.val;
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
                size--;
            }
//            for (int i = 0; i < size; i++) {
//                TreeNode poll = queue.poll();
//                if (i == 0) {
//                    res = poll.val;
//                }
//                if (poll.left != null) {
//                    queue.offer(poll.left);
//                }
//                if (poll.right != null) {
//                    queue.offer(poll.right);
//                }
//            }
        }
        return res;
    }
}
