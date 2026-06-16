import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
public class CloneGraphLeetCode {

    public class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    public Node cloneGraph(Node node) {
        if(node==null) return null;
        HashMap<Integer,Node> map = new HashMap<Integer, Node>();
        return dfs(node, map);
    }

    public Node dfs(Node node, HashMap<Integer,Node> map){
        Node newNode = new Node(node.val);
        map.put(node.val, newNode);
        for(Node n: node.neighbors){
            if(!map.containsKey(n.val))
                dfs(n,map);
            newNode.neighbors.add(map.get(n.val));
        }
        return newNode;
    }

    public static void main(String[] args) {
        CloneGraphLeetCode c = new CloneGraphLeetCode();
        Node node1 = c.new Node(1);
        Node node2 = c.new Node(2);
        Node node3 = c.new Node(3);
        Node node4 = c.new Node(4);
        node1.neighbors.add(node2);
        node1.neighbors.add(node4);
        node2.neighbors.add(node1);
        node2.neighbors.add(node3);
        node3.neighbors.add(node2);
        node3.neighbors.add(node4);
        node4.neighbors.add(node1);
        node4.neighbors.add(node3);

        System.out.println(c.cloneGraph(node1).val);
    }
}
