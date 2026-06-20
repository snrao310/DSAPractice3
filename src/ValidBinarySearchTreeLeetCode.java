public class ValidBinarySearchTreeLeetCode {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static boolean isValidBST(TreeNode root) {
        return isValidBSTRecursive(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public static boolean isValidBSTRecursive(TreeNode root, int min, int max){
        if(root==null) return true;
        if(root.left!=null){
            if(root.left.val>=root.val || root.left.val<=min || root.left.val>=max) return false;
            if(!isValidBSTRecursive(root.left, min, root.val)) return false;
        }
        if(root.right!=null){
            if(root.right.val<=root.val || root.right.val<=min || root.right.val>=max) return false;
            if(!isValidBSTRecursive(root.right, root.val, max)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        System.out.println(isValidBST(root));
    }
    
}
