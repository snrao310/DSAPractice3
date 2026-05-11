public class MergeKSortedLinkedListsLeetCode {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        return merge(lists, 0, lists.length-1);
    }

    public static ListNode merge(ListNode[] lists, int i, int j) {
        if(i==j) return lists[i];
        ListNode l = merge(lists,i,(i+j)/2);
        ListNode r = merge(lists,(i+j)/2+1,j);
        ListNode headPrev = new ListNode(0);
        ListNode cur = headPrev;
        while(l!=null || r!=null){
            if(l==null){
                cur.next = r;
                cur=r;
                r=r.next;
                continue;
            }
            if(r==null){
                cur.next = l;
                cur=l;
                l=l.next;
                continue;
            }
            if(l.val<r.val){
                cur.next = l;
                cur = l;
                l=l.next;
            }
            else{
                cur.next = r;
                cur=r;
                r=r.next;
            }
        }
        return headPrev.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(4);
        node1.next.next = new ListNode(5);

        ListNode node2 = new ListNode(1);
        node2.next = new ListNode(3);
        node2.next.next = new ListNode(4);

        ListNode node3 = new ListNode(2);
        node3.next = new ListNode(6);

        ListNode[] lists = {node1, node2, node3};
        ListNode head = mergeKLists(lists);
        while(head!=null){
            System.out.print(head.val+" ");
            head = head.next;
        }
    }
    
}
