import java.util.HashMap;

public class BinaryTreeMaximumPathSumLeetCode {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static int max = Integer.MIN_VALUE;

    public static int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        HashMap<TreeNode, int[]> map = new HashMap<>();
        traverse(root, map);
        return max;
    }

    public static void traverse(TreeNode root, HashMap<TreeNode, int[]> map) {
        int[] sumsleft = { 0, 0, 0 };
        int[] sumsright = { 0, 0, 0 };
        if (root.left != null) {
            traverse(root.left, map);
            sumsleft = map.get(root.left);
        }
        if (root.right != null) {
            traverse(root.right, map);
            sumsright = map.get(root.right);
        }
        int cursumleft = Math.max(sumsleft[0], sumsleft[1]) + root.val;
        cursumleft = Math.max(cursumleft, root.val);
        int cursumright = Math.max(sumsright[0], sumsright[1]) + root.val;
        cursumright = Math.max(cursumright, root.val);
        int cursumcircle = Math.max(sumsleft[0], sumsleft[1]) + Math.max(sumsright[0], sumsright[1]) + root.val;
        cursumcircle = Math.max(cursumcircle, root.val);
        map.put(root, new int[] { cursumleft, cursumright, cursumcircle });
        max = Math.max(Math.max(cursumleft, cursumright), Math.max(cursumcircle, max));
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(-15);
        root.left = new TreeNode(10);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.left.left = new TreeNode(-5);
        root.right.right = new TreeNode(5);
        int res = maxPathSum(root);
        System.out.println(res);
    }

}
