package Day17;


import java.util.ArrayList;
import java.util.List;

//需要注意众数可能不止一个
public class 二叉搜索树中的众数 {
    List<Integer> list = new ArrayList<>();
    int max = 0;
    int count = 0;
    //pre为前一个节点 是为了重置计数以及计数
    TreeNode pre = null;
    public int[] findMode(TreeNode root) {
        if (root == null) return new int[0];
        dfs(root);
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
    public void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.left);
        //计数逻辑
        if (pre == null || pre.val != root.val){
            count = 1;
        }else {
            count++;
        }
        if (count > max){
            max = count;
            //清空列表
            list.clear();
            list.add(root.val);
        }else if (count == max){
            list.add(root.val);
        }
        //这里需要记录上一个访问的节点
        pre = root;
        dfs(root.right);
    }
}
