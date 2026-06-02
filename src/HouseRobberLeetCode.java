import java.util.Arrays;

public class HouseRobberLeetCode {

    public static int rob(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return robDp(nums, 0, dp);
    }

    public static int robDp(int[] nums, int i, int[] dp) {
        int n = nums.length;
        if (i == n - 1)
            return nums[i];
        if (i == n - 2)
            return Math.max(nums[i], nums[i + 1]);
        if (i == n)
            return 0;
        if (dp[i] != -1)
            return dp[i];
        dp[i] = Math.max(nums[i] + robDp(nums, i + 2, dp), robDp(nums, i + 1, dp));
        return dp[i];
    }

    public static void main(String[] args) {
        int[] nums = { 1, 1, 3, 3 };
        System.out.println(rob(nums));
        nums = new int[] { 2, 9, 8, 3, 6 };
        System.out.println(rob(nums));
    }

}
