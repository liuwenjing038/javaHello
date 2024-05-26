package Day3;

public class 设计链表 {
    int size;
    ListNode head;

    public 设计链表() {
        size = 0;
        head =new ListNode(0);
    }

    public int get(int index) {
        if (index<0 || index>=size) return -1;
        ListNode cur = head;

        //这里的循环次数是index+1  即<=号  因为包含一个虚结点  所以需要多走一步
        for (int i = 0; i <= index ; i++) {
            cur = cur.next;
        }
        return cur.val;
    }

    public void addAtHead(int val) {
        addAtIndex(0,val);
    }

    public void addAtTail(int val) {
        addAtIndex(size,val);
    }

    public void addAtIndex(int index, int val) {
        if (index >size) return;
        if (index<0) index=0;
        size++;
        ListNode cur = head;
        //找到前一个结点  这里也是因为有一个虚结点 因此寻找前一个没有=
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        ListNode addNode = new ListNode(val);
        //这里需要先找到后一个结点
        addNode.next = cur.next;
        cur.next = addNode;
    }

    public void deleteAtIndex(int index) {
        if (index<0 || index>=size) return;
        //这里需要注意size--应该在下面index==0之前   不然return会导致少减一次
        size--;
        if (index == 0) {
            head = head.next;
            //这一定注意需要return掉
            return;
        }

        ListNode cur = head;
        //找到前一个结点
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.next = cur.next.next;
    }


    public static void main(String[] args) {
        设计链表 obj = new 设计链表();
        obj.addAtHead(1);
        obj.addAtTail(3);
        obj.addAtIndex(1,2);
        System.out.println(obj.get(1));
        obj.deleteAtIndex(1);
        System.out.println(obj.get(1));
        System.out.println(obj.get(3));
        obj.deleteAtIndex(3);
        obj.deleteAtIndex(0);
        System.out.println(obj.get(0));
        obj.deleteAtIndex(0);
        System.out.println(obj.get(0));
    }
}
