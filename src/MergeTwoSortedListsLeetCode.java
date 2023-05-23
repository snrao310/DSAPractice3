public class MergeTwoSortedListsLeetCode {

    static class ListNode{
        int val;
        ListNode next;
        public ListNode(int val){
            this.val = val;
        }
        public ListNode(int val,ListNode next){
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode temp1 = list1, temp2 = list2, temp3 = null, nextNode = null, res = null;
        while (temp1 != null || temp2 != null) {
            if (temp1 == null) {
                nextNode = temp2;
                temp2 = temp2.next;
            } else if (temp2 == null) {
                nextNode = temp1;
                temp1 = temp1.next;
            } else if (temp1.val < temp2.val) {
                nextNode = temp1;
                temp1 = temp1.next;
            } else {
                nextNode = temp2;
                temp2 = temp2.next;
            }
            if (temp3 != null) {
                temp3.next = nextNode;
                temp3 = temp3.next;
            } else {
                temp3 = nextNode;
                res = temp3;
            }
        }
        return res;
    }

    public static void main(String args[]){
        ListNode one = new ListNode(1);
        one.next = new ListNode(2);
        one.next.next = new ListNode(4);
        ListNode two = new ListNode(1);
        two.next = new ListNode(3);
        two.next.next = new ListNode(4);
        ListNode newList = mergeTwoLists(one,two);
        while(newList!=null){
            System.out.print(newList.val+" ");
            newList = newList.next;
        }
    }
}
