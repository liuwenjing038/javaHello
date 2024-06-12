package Day13;

public class N叉树的最大深度 {

    public int maxDepth(Node root) {
        if (root == null) return 0;
        int height = 0;
        for (Node node: root.children){
            //写N叉树遍历的时候多判断了一个root.children!=null  其实没必要
            height = Math.max(height, maxDepth(node));
        }
        //本质上还是后序遍历  最后做本层操作
        return height + 1;
    }
}
