import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SerializeAndDeserializeBinaryTreeLeetCode {

    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){val=x;}
    }

    public static TreeNode createTree(){
        TreeNode root=new TreeNode(3);
        TreeNode one=new TreeNode(1);
        TreeNode two= new TreeNode(2);
        TreeNode four=new TreeNode(4);
        TreeNode five= new TreeNode(5);
        root.left=one; root.right=five; five.left=four; one.right=two;
        return root;
    }

    public static void inOrder(TreeNode node, List<Integer> list){
        if(node==null) return;
        inOrder(node.left,list);
        list.add(node.val);
        inOrder(node.right,list);
    }

    public static void preOrder(TreeNode node, List<Integer> list){
        if(node==null) return;
        list.add(node.val);
        preOrder(node.left,list);
        preOrder(node.right,list);
    }


    public static class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            StringBuilder sb = new StringBuilder();
            buildString(sb, root);
            return sb.toString().substring(1);
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
           String[] nodes = data.split(" ");
           Queue<String> nodeQueue = new LinkedList<>();
            for (String node:
                 nodes) {
                nodeQueue.offer(node);
            }
           TreeNode root = buildTree(nodeQueue);
           return root;
        }

        public void buildString(StringBuilder sb, TreeNode root){
            String code = (root==null)? " X" : " "+Integer.toString(root.val);
            sb.append(code);
            if(root != null) {
                buildString(sb,root.left);
                buildString(sb,root.right);
            }
        }

        public TreeNode buildTree(Queue<String> nodes){
            String rootVal = nodes.poll();
            if(rootVal.equals("X")){
                return null;
            }
            TreeNode root = new TreeNode(Integer.parseInt(rootVal));
            root.left = buildTree(nodes);
            root.right = buildTree(nodes);
            return root;
        }
    }

    public static void main(String args[]){
        TreeNode root=createTree();
        Codec codec = new Codec();
        root=codec.deserialize(codec.serialize(root));
        List<Integer> in=new ArrayList<>();
        inOrder(root,in);
        List<Integer> pre=new ArrayList<>();
        preOrder(root,pre);
        for(int i: in) System.out.print(i+" ");
        System.out.println();
        for(int i: pre) System.out.print(i+" ");
    }
}
