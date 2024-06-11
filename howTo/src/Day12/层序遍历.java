package Day12;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 层序遍历 {
    public List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        //确定入参和返回值
//        leverOrder01(root,0);
        leverOrder02(root);
        return res;
    }

    //使用递归的方式
    public void leverOrder01(TreeNode root,int level) {
        //确定终止条件
        if(root == null) return;
        level++;
        if (res.size() < level){
            res.add(new ArrayList<>());
        }
        res.get(level-1).add(root.val);

        //进入下层循环
        leverOrder01(root.left,level);
        leverOrder01(root.right,level);

    }

    public void leverOrder02(TreeNode root) {
        if (root == null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        //offer比add更加安全
        queue.offer(root);
        while (!queue.isEmpty()){
            List<Integer> list = new ArrayList<>();
            //一层一层输入输出 统计一层的数量 在出队列时把下一层都输入
            int size = queue.size();
            while (size > 0){
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
                size--;
            }
            res.add(list);
        }
    }
}
