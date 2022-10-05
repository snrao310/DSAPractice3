public class AddTwoNumbersLeetCode {

    private static class ListNode{
        public int val;
        public ListNode next;
        ListNode(int x) {val =x;}
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode res= new ListNode(0);
        ListNode res_cur = res;
        while(l1!=null || l2!=null){
            int l1_val = (l1==null)?0:l1.val;
            int l2_val = (l2==null)?0:l2.val;
            int sum_val = l1_val+l2_val+carry;
            res_cur.val = sum_val%10;
            carry = sum_val/10;
            l1 = (l1==null)?null:l1.next;
            l2 = (l2==null)?null:l2.next;
            if(l1!=null || l2!=null) {
                res_cur.next = new ListNode(0);
                res_cur = res_cur.next;
            }else if(carry!=0){
                res_cur.next = new ListNode(carry);
            }
        }
        return res;
    }

    public static void main(String[] args){
        ListNode first = new ListNode(2);
        first.next = new ListNode(4);
        first.next.next = new ListNode(3);
        ListNode second = new ListNode(5);
        second.next = new ListNode(6);
        second.next.next = new ListNode(4);
        ListNode sum = addTwoNumbers(first,second);
        while(sum!=null){
            System.out.println(sum.val);
            sum=sum.next;
        }
    }
}
