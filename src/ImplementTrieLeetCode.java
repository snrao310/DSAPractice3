import java.util.HashMap;

public class ImplementTrieLeetCode {

    public static class PrefixTree {
        class Node {
            boolean end;
            HashMap<Character, Node> children;

            public Node() {
                children = new HashMap<Character, Node>();
                end = false;
            }
        }

        Node root;

        public PrefixTree() {
            root = new Node();
        }

        public void insert(String word) {
            char[] w = word.toCharArray();
            Node cur = root;
            for (char c : w) {
                HashMap<Character, Node> children = cur.children;
                if (!children.containsKey(c)) {
                    Node newNode = new Node();
                    children.put(c, newNode);
                }
                cur = children.get(c);
            }
            cur.end = true;
        }

        public boolean search(String word) {
            char[] w = word.toCharArray();
            Node cur = root;
            for (char c : w) {
                HashMap<Character, Node> children = cur.children;
                if (!children.containsKey(c))
                    return false;
                cur = children.get(c);
            }
            return cur.end;
        }

        public boolean startsWith(String prefix) {
            char[] w = prefix.toCharArray();
            Node cur = root;
            for (char c : w) {
                HashMap<Character, Node> children = cur.children;
                if (!children.containsKey(c))
                    return false;
                cur = children.get(c);
            }
            return true;
        }
    }

    public static void main(String[] args) {
        PrefixTree trie = new PrefixTree();
        trie.insert("apple");
        System.out.println(trie.search("apple"));   // returns true
        System.out.println(trie.search("app"));     // returns false
        System.out.println(trie.startsWith("app")); // returns true
        trie.insert("app");
        System.out.println(trie.search("app"));     // returns true
    }

}
