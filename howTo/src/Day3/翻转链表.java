package Day3;

public class 翻转链表 {
    public ListNode reverseList(ListNode head) {

        //双指针
        ListNode pre = null;
        ListNode cur = head;
        ListNode temp = null;
        while (cur != null){
            temp = cur.next;  //记录下一个结点
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }
}
