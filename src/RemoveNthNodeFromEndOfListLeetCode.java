public class RemoveNthNodeFromEndOfListLeetCode {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode headPrev = new ListNode();
        headPrev.next = head;
        ListNode cur= head;
        int len=0;
        while(cur!=null){
            len++;
            cur=cur.next;
        }
        int nodeFromHead = len-n;
        int i=1;
        ListNode prev=headPrev;
        cur=head;
        while(i<=nodeFromHead){
            prev=cur;
            cur=cur.next;
            i++;
        }
        prev.next = cur.next;
        return headPrev.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        int n = 2;
        ListNode result = removeNthFromEnd(head, n);

        // Print the modified linked list
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
    
}
