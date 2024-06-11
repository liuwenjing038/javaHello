package Day12;

import java.util.*;

//从底层往上层输出
public class 层序遍历二 {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {

//        levelOrder01(root,0);
        levelOrder02(root);
        Collections.reverse(res);
        return res;
    }

    public void levelOrder01(TreeNode root,int level){
        if (root == null) return;
        level++;
        if (res.size() < level){
            res.add(new ArrayList<>());
        }
        res.get(level-1).add(root.val);
        if (root.left != null) levelOrder01(root.left,level);
        if (root.right != null) levelOrder01(root.right,level);
    }


    public void levelOrder02(TreeNode root){
        if (root == null) return;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            List<Integer> temp = new ArrayList<>();
            int size = queue.size();
            while (size > 0){
                TreeNode node = queue.poll();
                temp.add(node.val);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
                size--;
            }
            res.add(temp);
        }
    }
}
