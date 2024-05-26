package Day4;

public class 环形链表 {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head, slow = head;
        //这里因为fast一次走两步所以需要判断next
        while (fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow){  //说明有环  接下来找环的入口

                //这里需要注意起点到环入口的距离和相交点到环入口的距离一致
                ListNode node1 = fast;
                ListNode node2 = head;
                while (node1!=node2){
                    node1 = node1.next;
                    node2 = node2.next;
                }
                return node1;
            }
        }
        return null;
    }
}
