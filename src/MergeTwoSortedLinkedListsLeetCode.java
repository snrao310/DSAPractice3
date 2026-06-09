public class MergeTwoSortedLinkedListsLeetCode {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode cur1 = list1, cur2 = list2, headPrev = new ListNode(), cur = headPrev;
        while(cur1!=null || cur2!=null){
            if(cur1==null){
                cur.next = cur2;
                cur2 = cur2.next;
            }
            else if(cur2==null){
                cur.next = cur1;
                cur1 = cur1.next;
            }
            else if(cur1.val<cur2.val){
                cur.next = cur1;
                cur1=cur1.next;
            }
            else{
                cur.next = cur2;
                cur2 = cur2.next;
            }
            cur = cur.next;
        }
        return headPrev.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        ListNode head = mergeTwoLists(l1, l2);
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }

}
