package Day4;

public class 删除链表的倒数第N个结点 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //首先创建一个虚拟的头结点dummy
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        //然后创建两个指针指向dummy
        ListNode fastIndex = dummy;
        ListNode slowIndex = dummy;
        //先让快指针走N步  这里需要注意的是因为删除需要从前一个结点删 因此需要多走一步 这里的=
        for (int i = 0; i <=n ; i++) {
            fastIndex = fastIndex.next;
        }
        //然后快慢指针一起走
        while (fastIndex!=null){
            fastIndex = fastIndex.next;
            slowIndex = slowIndex.next;
        }
        //此时slowIndex的下一个结点就是要删除的结点
        if (slowIndex.next!=null){   //这里判不判不影响结果
            slowIndex.next = slowIndex.next.next;
        }
        return dummy.next;
    }
}
