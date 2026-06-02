public class ReverseLinkedListLeetCode {

        public static class ListNode {
            int val;
            ListNode next;
            ListNode(int x) { val = x; }
        }

    public static ListNode reverseList(ListNode head) {
        if(head==null || head.next==null) return head;
        ListNode cur = head.next;
        ListNode curPrev = head;
        curPrev.next = null;
        while(cur!=null){
            ListNode curNext = cur.next;
            cur.next = curPrev;
            curPrev = cur;
            cur = curNext;
        }
        return curPrev;
    }

    public static void main(String [] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode result = reverseList(head);
        while(result!=null){
            System.out.println(result.val);
            result=result.next;
        }
    }
    
}
