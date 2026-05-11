import java.util.HashMap;

public class LRUCacheLeetCode {

    public static class LRUCache {

        public class ListNode {
            int key;
            int val;
            ListNode prev;
            ListNode next;

            ListNode(int key, int val) {
                this.key = key;
                this.val = val;
            }
        }

        int size;
        int capacity;
        HashMap<Integer, ListNode> map = new HashMap<>();
        ListNode head, rec;

        public LRUCache(int capacity) {
            size = 0;
            this.capacity = capacity;
        }

        public int get(int key) {
            ListNode node = map.get(key);
            if (node == null)
                return -1;
            if (node == rec)
                return node.val;
            if (node == head)
                head = head.next;
            ListNode prev = node.prev;
            ListNode next = node.next;
            next.prev = prev;
            if (prev != null)
                prev.next = next;
            node.next = null;
            node.prev = rec;
            rec.next = node;
            rec = node;
            return node.val;
        }

        public void put(int key, int value) {
            if (capacity == 0)
                return;
            ListNode node;
            if (map.containsKey(key)) {
                node = map.get(key);
                node.val = value;
                get(key);
                return;
            }

            node = new ListNode(key, value);
            map.put(key, node);
            if (head == null) {
                head = node;
                rec = node;
            } else {
                rec.next = node;
                node.prev = rec;
                rec = node;
            }
            size++;
            if (size > capacity) {
                map.remove(head.key);
                head = head.next;
            }
        }
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1)); // returns 1
        cache.put(3, 3); // evicts key 2
        System.out.println(cache.get(2)); // returns -1 (not found)
        cache.put(4, 4); // evicts key 3
        System.out.println(cache.get(3)); // returns -1 (not found)
        System.out.println(cache.get(4)); // returns 4
    }

}
