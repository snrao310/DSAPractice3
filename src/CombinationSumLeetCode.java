import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumLeetCode {

    public static List<List<Integer>> combinationSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        backtrack(nums, target, 0, res, new ArrayList<Integer>());
        return res;
    }

    public static void backtrack(int[] nums, int target, int i, List<List<Integer>> res, List<Integer> tempList) {
        if(target==0){
            res.add(new ArrayList<Integer>(tempList));
            return;
        }
        if (i == nums.length || target < 0)
            return;
        tempList.add(nums[i]);
        backtrack(nums, target - nums[i], i, res, tempList);
        tempList.removeLast();
        while(i<nums.length-1 && nums[i]==nums[i+1]){
            i++;
        }
        backtrack(nums, target, i+1, res, tempList);
    }

    public static void main(String[] args) {
        int[] candidates = { 3,4,5 };
        int target = 10;
        System.out.println(combinationSum(candidates, target));
    }

}
