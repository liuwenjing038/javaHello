package Day12;

import java.util.ArrayList;
import java.util.List;


//用递归改造一下即可
public class N叉树的遍历 {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> levelOrder(Node root) {
        levelOrder01(root,0);
        return res;
    }

    public void levelOrder01(Node root,int level){
        if (root == null) return;
        level++;
        if (res.size() < level){res.add(new ArrayList<>());}
        res.get(level-1).add(root.val);
        for (Node node: root.children) {
            if (node.children != null) levelOrder01(node,level);
        }
    }
}
