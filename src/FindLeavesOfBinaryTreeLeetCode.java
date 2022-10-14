import java.util.ArrayList;
import java.util.List;

public class FindLeavesOfBinaryTreeLeetCode {

    public static class TreeNode{
        int val;
        TreeNode left, right;
        TreeNode(int v){
            val = v;
        }
        TreeNode(int v, TreeNode l, TreeNode r){
            val = v; left = l; right = r;
        }
    }

    public static TreeNode createTree(){
        TreeNode root=new TreeNode(3);
        TreeNode one=new TreeNode(1);
        TreeNode two= new TreeNode(2);
        TreeNode four=new TreeNode(4);
        TreeNode five= new TreeNode(5);
        root.left=one; root.right=five; five.left=four; one.right=two;
        return root;
    }

    public static int getHeight(TreeNode root, List<List<Integer>> res){
        if(root==null) return 0;
        int lHeight = getHeight(root.left, res);
        int rHeight = getHeight(root.right, res);
        int curHeight = Math.max(lHeight, rHeight);
        if(res.size() == curHeight){
            res.add(new ArrayList<>());
        }
        res.get(curHeight).add(root.val);
        return curHeight+1;
    }

    public static List<List<Integer>> findLeaves(TreeNode root){
        List<List<Integer>> res = new ArrayList<>();
        getHeight(root, res);
        return res;
    }

    public static void main(String[] args){
        TreeNode root = createTree();
        List<List<Integer>> response = findLeaves(root);
        System.out.println(response);
    }
}
