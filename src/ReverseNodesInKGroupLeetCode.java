public class ReverseNodesInKGroupLeetCode {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(){}
        ListNode(int x) {
            val = x;
        }
    }


    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode headPrev = new ListNode();
        headPrev.next=head;
        ListNode prev = headPrev,end =headPrev,next = head, start=headPrev;
        while(true){
            prev = start;
            ListNode cur = next;
            int i=0;
            while(i<k && cur!=null){
                end = cur;cur=cur.next;i++;
            }
            if(i!=k) break;
            next = cur;
            start = prev.next;
            ListNode node = start.next, nodePrev = start;
            while(node!=next){
                ListNode nodeNext = node.next;
                node.next = nodePrev;
                nodePrev = node;
                node = nodeNext;
            }
            prev.next = end;
            start.next = next;
        }
        return headPrev.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next.next = new ListNode(8);
        head = reverseKGroup(head, 3);
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
    
}
