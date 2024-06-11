package Day12;


class Node1 {
    public int val;
    public Node1 left;
    public Node1 right;
    public Node1 next;

    public Node1() {}

    public Node1(int _val) {
        val = _val;
    }

    public Node1(int _val, Node1 _left, Node1 _right, Node1 _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}
public class 填充每个节点的下一个右侧节点指针 {
    public Node1 connect(Node1 root) {
        if (root == null) return null;
        //寻租next  left 和right 的关系
        if (root.left != null){
            root.left.next = root.right;
            if (root.next != null){
                root.right.next = root.next.left;
            }
        }

        connect(root.left);
        connect(root.right);
        return root;
    }
}
