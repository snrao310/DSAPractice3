import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class BurstBalloonsLeetCode {

    public static int maxCoins(int[] nums) {
        int[][] dp = new int[nums.length][nums.length];
        for (int[] d : dp)
            Arrays.fill(d, -1);
        return getCoins(0, nums.length - 1, nums, dp);
    }

    public static int getCoins(int l, int r, int[] nums, int[][] dp) {
        if (dp[l][r] != -1)
            return dp[l][r];
        int max = Integer.MIN_VALUE;
        for (int i = l; i <= r; i++) {
            int prev = (l == 0) ? 1 : nums[l - 1];
            int next = (r == nums.length-1) ? 1 : nums[r + 1];
            int dpprev = (i > 0 && i>l) ? getCoins(l, i-1, nums, dp): 0;
            int dpnext = (i < nums.length - 1 && i<r) ? getCoins(i+1,r,nums,dp) : 0;
            int val = prev * nums[i] * next + dpprev + dpnext;
            max = Math.max(val, max);
        }
        dp[l][r] = max;
        return max;
    }

    public static void main(String[] args) {
        int[] nums = { 3, 1, 5, 8 };
        System.out.println(maxCoins(nums));
    }

}