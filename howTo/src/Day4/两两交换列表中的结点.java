package Day4;



public class 两两交换列表中的结点 {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(-1,head);
        dummy.next = head;
        ListNode cur = dummy;
        //这里把要重组的三个结点都保存下来交换会清晰一点
        ListNode tmep3;
        ListNode tmep1;
        ListNode tmep2;
        //这里next和next.next都判断的原因是偶数是next就为空了  再判断next.next会空指针
        while (cur.next != null && cur.next.next!=null){
            tmep3 = cur.next.next.next;
            tmep1 = cur.next;
            tmep2 = cur.next.next;
            cur.next = tmep2;
            tmep2.next = tmep1;
            tmep1.next = tmep3;
            cur = cur.next.next;
        }
        return dummy.next;
    }
}
