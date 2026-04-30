public class AddTwoNumbersLeetCode {

    private static class ListNode{
        public int val;
        public ListNode next;
        ListNode(int x) {val =x;}
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode cur1=l1,cur2=l2;
        ListNode res= null;
        ListNode copy = res;
        int sumCarry = 0;
        while(cur1!=null || cur2!=null){
            int cur1val= cur1!=null?cur1.val:0;
            int cur2val= cur2!=null?cur2.val:0;
            int sumval = cur1val+cur2val+sumCarry;
            ListNode sumNode = new ListNode(sumval%10);
            sumCarry = sumval/10;
            if(cur1==l1){
                res = sumNode;
            }
            else{
                copy.next = sumNode;
            }
            copy = sumNode;
            cur1 = cur1!=null?cur1.next:null;
            cur2 = cur2!=null?cur2.next:null;
        }
        if(sumCarry!=0){
            copy.next = new ListNode(sumCarry);
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
