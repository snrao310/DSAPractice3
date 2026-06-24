import java.util.ArrayList;
import java.util.List;

public class SubsetsLeetCode {

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        backtrack(nums, 0, res, new ArrayList<Integer>());
        return res;
    }

    public static void backtrack(int[] nums, int i, List<List<Integer>> res, List<Integer> tempList) {
        if (i == nums.length) {
            res.add(new ArrayList<Integer>(tempList));
            return;
        }
        tempList.add(nums[i]);
        backtrack(nums, i + 1, res, tempList);
        tempList.removeLast();
        backtrack(nums, i + 1, res, tempList);
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3 };
        System.out.println(subsets(nums));
    }

}