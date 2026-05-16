public class ConstructBinaryTreeFromPreorderAndInorderTraversalLeetCode {

    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val){
            this.val = val;
        }
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length==0) return null;
        return buildSubtree(preorder,inorder,0,preorder.length-1,0,inorder.length-1);
    }

    public static TreeNode buildSubtree(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd){
        int len = preorder.length;
        if(preStart>=len || preEnd <0 || inStart>=len || inEnd<0 || preStart>preEnd || inStart>inEnd) return null;
        if(preStart==preEnd) return new TreeNode(preorder[preStart]);
        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);
        for(int i=inStart;i<=inEnd;i++){
            if(inorder[i]==rootVal){
                int leftCnt = i-inStart;
                root.left = buildSubtree(preorder, inorder, preStart+1, preStart+leftCnt, inStart, i-1);
                root.right = buildSubtree(preorder, inorder, preStart+leftCnt+1, preEnd, i+1, inEnd);
            }
        }
        return root;
    }

    public static void inOrder(TreeNode root){
        if(root==null) return;
        inOrder(root.left);
        System.out.print(root.val+" ");
        inOrder(root.right);
    }

    public static void preOrder(TreeNode root){
        if(root==null) return;
        System.out.print(root.val+" ");
        inOrder(root.left);
        inOrder(root.right);
    }

    public static void main(String[] args) {
        int[] preorder = {1,2,3,4};
        int[] inorder = {2,1,3,4};
        TreeNode root = buildTree(preorder,inorder);
        preOrder(root);
        System.out.println();
        inOrder(root);
        System.out.println();
    }
}
