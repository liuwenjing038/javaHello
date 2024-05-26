package Day4;

public class 链表相交 {
    //非常特殊的想法 A走完走B  B走完走A 终会相交
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode A = headA, B = headB;
        while (A != B){
            A = A == null ? headB : A.next;
            B = B == null ? headA : B.next;
        }
        return  A;
    }
}
