import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class PermutationsLeetCode {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        backtrack(nums, new HashSet<Integer>(), new ArrayList<Integer>(), res);
        return res;
    }

    public void backtrack(int[] nums, HashSet<Integer> set, List<Integer> tempList, List<List<Integer>> res){
        if(set.size()==nums.length){
            res.add(new ArrayList(tempList));
        }

        for(int i=0;i<nums.length;i++){
            if(set.contains(nums[i]))continue;
            set.add(nums[i]);
            tempList.add(nums[i]);
            backtrack(nums,set,tempList,res);
            tempList.removeLast();
            set.remove(nums[i]);
        }
    }

    public static void main(String[] args) {
        PermutationsLeetCode pl = new PermutationsLeetCode();
        int[] nums = {1,2,3};
        List<List<Integer>> res = pl.permute(nums);
        for(List<Integer> l: res){
            System.out.println(l);
        }
    }
    
}
