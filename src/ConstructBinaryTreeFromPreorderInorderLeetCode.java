
public class ConstructBinaryTreeFromPreorderInorderLeetCode {

    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val){this.val=val;}
    }

    public static void inOrderTraverse(TreeNode node){
        if(node==null)
            return;
        inOrderTraverse(node.left);
        System.out.print(node.val+" ");
        inOrderTraverse(node.right);
    }


    public static void preOrderTraverse(TreeNode node){
        if(node==null)
            return;
        System.out.print(node.val+" ");
        preOrderTraverse(node.left);
        preOrderTraverse(node.right);
    }


    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length ==0 || inorder.length ==0 || preorder.length!=inorder.length){
            return null;
        }
        return buildTree(preorder,inorder,0,preorder.length-1,0,inorder.length-1);
    }

    private static TreeNode buildTree(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd){
        if(preStart>preEnd || inStart>inEnd){
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        int leftInEnd = -1, rightInStart = -1,leftPreEnd = -1,rightPreStart = -1;

        for(int i=inStart,leftSize = 0;i<=inEnd;i++,leftSize++){
            if(inorder[i]==root.val){
                leftInEnd = i-1;
                leftPreEnd = preStart + leftSize;
                rightPreStart = leftPreEnd +1;
                rightInStart = i+1;
                break;
            }
        }
        root.left = buildTree(preorder,inorder,preStart+1, leftPreEnd,inStart,leftInEnd);
        root.right = buildTree(preorder,inorder,rightPreStart,preEnd,rightInStart,inEnd);

        return root;
    }



    public static void main(String args[]){
        int[] inOrder={6,5,8,3,4,7};
        int[] preOrder={3,5,6,8,4,7};
        TreeNode root=buildTree(preOrder,inOrder);
        inOrderTraverse(root);
        System.out.println();
        preOrderTraverse(root);
    }

}
