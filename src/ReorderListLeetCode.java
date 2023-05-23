
public class ReorderListLeetCode {

    static class ListNode{
        int val;
        ListNode next;
        ListNode(int val){
            this.val = val;
        }
        ListNode(int val,ListNode next){
            this.val = val;
            this.next = next;
        }
    }

    public static void reorderList(ListNode head) {
        ListNode half = head, full = head;
        while(full!=null){
            full = full.next;
            if(full!=null) {
                full = full.next;
                half = half.next;
            }
        }
        ListNode temp= half.next;
        ListNode tempNext = temp== null? null :temp.next,tempNextNext;
        half.next = null;
        if(temp!=null)temp.next = null;
        while(tempNext != null){
                tempNextNext = tempNext.next;
                tempNext.next = temp;
                temp = tempNext;
                tempNext = tempNextNext;
        }
        ListNode temp1 = head, temp2 = temp;
        while(temp1!=null && temp2!=null){
            ListNode temp1Next = temp1.next;
            temp1.next = temp2;
            ListNode temp2Next = temp2.next;
            temp2.next = temp1Next;
            temp1 = temp1Next;
            temp2 = temp2Next;
        }
    }

    public static void main(String args[]){
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next= new ListNode(5);
        head.next.next.next.next.next= new ListNode(6);
        reorderList(head);
        while(head!=null){
            System.out.println(head.val+" ");
            head = head.next;
        }
    }
}
