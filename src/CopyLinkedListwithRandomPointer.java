import java.util.HashMap;
public class CopyLinkedListwithRandomPointer {
    
    static class Node {
        int val;
        Node next;
        Node random;
    
        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public static Node copyRandomList(Node head) {
        if (head==null){
            return null;
        }
        Node cur = head;
        Node headCopy = new Node(head.val);
        Node copy = headCopy;
        HashMap<Node, Node> map = new HashMap<Node, Node>();
        map.put(head, headCopy);
        while (cur.next!=null){
            cur=cur.next;
            copy.next=new Node(cur.val);
            copy=copy.next;
            map.put(cur,copy);
        }
        cur=head;
        copy=headCopy;
        Node random;
        while(cur!=null){
            random = cur.random;
            if(random!=null){
                copy.random=map.get(random);
            }
            cur=cur.next;
            copy=copy.next;
        }
        return headCopy;
    }

    public static void main(String[] args){
        Node head = new Node(3);
        head.next = new Node(7);
        head.next.next = new Node (5);
        // head.next.next.next = new Node(4);
        head.random = null;
        head.next.random = head.next.next;
        head.next.next.random = head;
        copyRandomList(head);
        System.out.println("val: "+head.val+" next: "+head.next.val+" random: "+head.random.val);
        head=head.next;
        System.out.println("val: "+head.val+" next: "+head.next.val+" random: "+head.random.val);
        head=head.next;
        System.out.println("val: "+head.val+" next: "+head.next.val+" random: "+head.random.val);

    }
}