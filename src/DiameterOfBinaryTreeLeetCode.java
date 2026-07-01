public class DiameterOfBinaryTreeLeetCode {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static int diam =0;

    public static int diameterOfBinaryTree(TreeNode root){
        diam=0;
        height(root);
        return diam;
    }

    public static int height(TreeNode root) {
        if(root==null) return 0;
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        diam = Math.max(diam, leftHeight+rightHeight);
        return Math.max(leftHeight, rightHeight)+1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        System.out.println(diameterOfBinaryTree(root));
    }
    
}
