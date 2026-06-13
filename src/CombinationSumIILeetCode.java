import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumIILeetCode {

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        return backtrack(candidates, target, 0);
    }

    public static List<List<Integer>> backtrack(int[] cand, int target, int i) {
        List<List<Integer>> res = new ArrayList<>();
        if (target == 0) {
            res.add(new ArrayList<>());
            return res;
        }
        if (i == cand.length || cand[i] > target)
            return res;

        res = backtrack(cand, target - cand[i], i + 1);
        for (List<Integer> list : res) {
            list.add(cand[i]);
        }
        int j = i;
        while (j < cand.length && cand[i] == cand[j]) {
            j++;
        }
        res.addAll(backtrack(cand, target, j));
        return res;
    }

    public static void main(String[] args) {
        int[] candidates = { 2, 2, 4 };
        System.out.println(combinationSum2(candidates, 4));
        candidates = new int[] { 1, 2, 3, 4, 5 };
        System.out.println(combinationSum2(candidates, 7));
    }

}
