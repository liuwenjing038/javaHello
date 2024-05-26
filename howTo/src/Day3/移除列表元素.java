package Day3;

public class 移除列表元素 {
    public ListNode removeElements(ListNode head, int val) {
        //这里使用虚拟头结点来统一操作
        if (head == null) return head;
        ListNode dummy = new ListNode(-1,head); //这里需要使用包含next的构造
        ListNode pre = dummy;
        ListNode cur = head;
        while (cur != null){
            if (cur.val == val){
                pre.next = cur.next;
            }else {
                pre = cur;
            }
            cur = cur.next;
        }
        return  dummy.next;
    }
}
