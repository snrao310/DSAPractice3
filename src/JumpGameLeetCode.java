public class JumpGameLeetCode {

    public static boolean canJump(int[] nums) {
        return canJumpDP(nums, new int[nums.length], 0);
    }

    public static boolean canJumpDP(int[] nums, int[] dp, int i) {
        if (i >= nums.length - 1)
            return true;
        if (nums[i] == 0)
            return false;
        if (dp[i] != 0)
            return dp[i] == 1;
        for (int ind = i + 1; ind <= (i + nums[i]); ind++) {
            if (canJumpDP(nums, dp, ind)) {
                dp[i] = 1;
                return true;
            }
        }
        dp[i] = -1;
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        System.out.println(canJump(nums));
    }

}
