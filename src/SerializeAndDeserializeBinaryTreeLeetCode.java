import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndDeserializeBinaryTreeLeetCode {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            StringBuilder sb = new StringBuilder();
            while (!queue.isEmpty()) {
                TreeNode e = queue.poll();
                if (e == null) {
                    sb.append("null,");
                } else {
                    sb.append(e.val + ",");
                    queue.add(e.left);
                    queue.add(e.right);
                }
            }
            return sb.toString();
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            String[] values = data.split(",");
            if (values[0].equals("null")) {
                return null;
            }
            Queue<TreeNode> queue = new LinkedList<>();
            TreeNode root = new TreeNode(Integer.valueOf(values[0]));
            queue.add(root);
            for (int i = 1; i + 1 < values.length;) {
                TreeNode cur = queue.poll();
                cur.left = values[i].equals("null") ? null : new TreeNode(Integer.valueOf(values[i]));
                cur.right = values[i+1].equals("null") ? null : new TreeNode(Integer.valueOf(values[i+1]));
                i+=2;
                if (cur.left != null)
                    queue.add(cur.left);
                if (cur.right != null)
                    queue.add(cur.right);
            }
            return root;
        }
    }

    public static void inOrder(TreeNode root){
        if(root==null) return;
        inOrder(root.left);
        System.out.print(root.val+ " ");
        inOrder(root.right);
    }

    public static void preOrder(TreeNode root){
        if(root==null) return;
        System.out.print(root.val+ " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        String result = new Codec().serialize(root);
        System.out.println(result);
        TreeNode deserializedRoot = new Codec().deserialize(result);
        inOrder(deserializedRoot);
        System.out.println();
        preOrder(deserializedRoot);
    }

}
