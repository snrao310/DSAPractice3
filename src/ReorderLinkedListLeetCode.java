public class ReorderLinkedListLeetCode {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void reorderList(ListNode head) {
        int len = 0;
        ListNode cur = head;
        while(cur!=null){
            cur=cur.next;
            len++;
        }
        if(len == 0 || len==1) return;
        int mid = (len%2==0)?len/2:len/2+1;
        int i=0;
        cur = head;
        while(i<mid-1){
            i++;
            cur=cur.next;
        }
        ListNode head2 = cur.next;
        cur.next = null;

        cur = head2.next;
        ListNode curPrev = head2;
        curPrev.next = null;
        while(cur!=null){
            ListNode temp = cur.next;
            cur.next = curPrev;
            curPrev = cur;
            cur = temp;
        }
        head2 = curPrev;

        cur=head;
        ListNode cur2 = head2;
        while(cur!=null && cur2!=null){
            ListNode temp = cur.next;
            ListNode temp2 = cur2.next;
            cur.next = cur2;
            cur2.next = temp;
            cur2 = temp2;
            cur = temp;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        reorderList(head);

        ListNode cur = head;
        while (cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
    }
    
}
