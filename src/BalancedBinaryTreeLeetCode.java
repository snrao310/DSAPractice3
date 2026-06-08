public class BalancedBinaryTreeLeetCode {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;
        int left = numLevels(root.left);
        int right = numLevels(root.right);
        if (left == -1 || right == -1)
            return false;
        return Math.abs(left - right) <= 1;
    }

    public static int numLevels(TreeNode root) {
        if (root == null)
            return 0;
        int left = numLevels(root.left);
        int right = numLevels(root.right);
        if (left == -1 || right == -1)
            return -1;
        if (Math.abs(left - right) > 1)
            return -1;
        else
            return Math.max(left, right) + 1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        System.out.println(isBalanced(root)); // true

        root.left.left.left = new TreeNode(6);
        System.out.println(isBalanced(root)); // false
    }

}
