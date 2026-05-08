import java.util.Arrays;

public class LongestIncreasingSubsequenceLeetCode {

    public static int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp,-1);
        int max = 0;
        for(int i=0;i<nums.length;i++){
        max = Math.max(max,lis(nums,dp,i));
        }
        return max;
    }

    public static int lis(int[] nums, int[] dp, int i){
        if(dp[i]!=-1) return dp[i];
        if(i==nums.length) return 1;
        int max = 0;
        for(int j=i+1;j<nums.length;j++){
            if(nums[j]>nums[i]){
                int m=lis(nums,dp,j);
                max = Math.max(max,m);
            }
        }
        dp[i] = max+1;
        return dp[i];
    }   

    
    public static void main(String[] args) {
        int[] nums = {10,9,2,5,3,7,101,18};
        System.out.println(lengthOfLIS(nums));
    }
}
