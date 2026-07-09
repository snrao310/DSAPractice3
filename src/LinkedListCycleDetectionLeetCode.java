import java.util.HashSet;

public class LinkedListCycleDetectionLeetCode {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static boolean hasCycle(ListNode head) {
        HashSet<ListNode> visited = new HashSet<ListNode>();
        ListNode cur = head;
        visited.add(head);
        while(cur!=null){
            cur=cur.next;
            if(visited.contains(cur)) return true;
            visited.add(cur);
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(-4);
        head.next.next.next.next = head.next;
        System.out.println(hasCycle(head));
    }
    
}
