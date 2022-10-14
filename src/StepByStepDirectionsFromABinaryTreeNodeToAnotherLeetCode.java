public class StepByStepDirectionsFromABinaryTreeNodeToAnotherLeetCode {


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static TreeNode findLCA(TreeNode root, int start, int dest) {
        if (root == null) return null;
        if (root.val == start || root.val == dest) return root;
        TreeNode l = findLCA(root.left, start, dest);
        TreeNode r = findLCA(root.right, start, dest);
        if(l == null && r==null) return null;
        else if(l!=null && r!=null) return root;
        return l==null?r:l;
    }

    public static TreeNode findStart(TreeNode n, int start, StringBuilder sb){
        if(n==null) return null;
        if(n.val == start) return n;
        TreeNode l = findStart(n.left, start, sb);
        TreeNode r = (l!=null)?null:findStart(n.right, start, sb);
        if(l==null && r==null) return null;
        sb.append("U");
        return l==null?r:l;
    }

    public static TreeNode findDest(TreeNode n, int dest, StringBuilder sb){
        if(n==null) return null;
        if(n.val == dest) return n;
        TreeNode l = findDest(n.left, dest, sb);
        TreeNode r = (l!=null)?null:findDest(n.right, dest, sb);
        if(l==null && r==null) return null;
        if(l!=null) sb.append("L");
        else sb.append("R");
        return l==null?r:l;
    }



    public static String getDirections(TreeNode root, int startValue, int destValue) {
        TreeNode lca =  findLCA(root, startValue, destValue);
        StringBuilder sb1 = new StringBuilder(), sb2 = new StringBuilder();
        findStart(lca, startValue,sb1);
        findDest(lca, destValue,sb2);
        return sb1.append(sb2.reverse()).toString();
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5, null, null);
        root.left = new TreeNode(1, null, null);
        root.left.left = new TreeNode(3, null, null);
        root.right = new TreeNode(2, null, null);
        root.right.left = new TreeNode(6, null, null);
        root.right.right = new TreeNode(4, null, null);
        System.out.println(getDirections(root, 3, 6));
    }
}
