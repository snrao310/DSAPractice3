import java.util.Arrays;

public class HouseRobberIILeetCode {

     public static int rob(int[] nums) {
        int[][] dp = new int[2][nums.length];
        Arrays.fill(dp[0],-1);
        Arrays.fill(dp[1],-1);
        return Math.max(nums[0]+robDp(nums, 2,true,dp),robDp(nums,1,false,dp));
    }
    public static int robDp(int[] nums, int i, boolean startIncluded, int[][] dp){
        int limit = startIncluded?nums.length-2:nums.length-1;
        int dpType = startIncluded?0:1;
        if(i>limit) return 0;
        if(i==limit) return nums[i];
        if(dp[dpType][i]!=-1) return dp[dpType][i];
        dp[dpType][i]=Math.max(nums[i]+robDp(nums, i+2, startIncluded, dp), robDp(nums, i+1, startIncluded, dp));
        return dp[dpType][i];
    }

    public static void main(String[] args) {
        int[] nums = { 1, 1, 3, 3 };
        System.out.println(rob(nums));
        nums = new int[] { 2, 9, 8, 3, 6 };
        System.out.println(rob(nums));
    }
    
}
