public class KthSmallestIntegerInBSTLeetCode {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static int cur = 0;
    public static int kthSmallest(TreeNode root, int k) {
        cur =0;
        return kth(root,k);
    }

    public static int kth(TreeNode root, int k){
        if(root==null) return 0;
        int val = kth(root.left,k);
        cur++;
        if(cur>k) return val;
        if(cur==k) return root.val;
        return kth(root.right,k);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.right = new TreeNode(2);

        int k = 1;
        int result = kthSmallest(root, k);
        System.out.println("The " + k + "-th smallest element in the BST is: " + result);
    }
    
}
