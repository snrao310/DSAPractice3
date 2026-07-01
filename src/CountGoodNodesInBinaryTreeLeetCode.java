public class CountGoodNodesInBinaryTreeLeetCode {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static int goodNodes(TreeNode root){
        return goodNodesMax(root, root.val);
    }

    public static int goodNodesMax(TreeNode root, int max) {
        if(root==null) return 0;
        int leftGood = goodNodesMax(root.left,Math.max(max,root.val));
        int rightGood = goodNodesMax(root.right,Math.max(max,root.val));
        int selfGood = (root.val>=max)?1:0;
        return leftGood + rightGood + selfGood;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(3);
        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(5);
        System.out.println(goodNodes(root));
    }
    
}
