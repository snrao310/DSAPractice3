import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsIILeetCode {

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        backtrack(nums, res, new ArrayList<Integer>(), 0);
        return res;
    }

    public static void backtrack(int[] nums, List<List<Integer>> res, List<Integer> tempList, int i) {
        if (i == nums.length) {
            res.add(new ArrayList(tempList));
            return;
        }
        tempList.add(nums[i]);
        backtrack(nums, res, tempList, i + 1);
        tempList.removeLast();
        while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
            i++;
        }
        backtrack(nums, res, tempList, i + 1);
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 2 };
        System.out.println(subsetsWithDup(nums));
    }

}
