public class PartitionEqualSubsetSumLeetCode {

    public static boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num: nums)
        sum+=num;
        if(sum%2==1) return false;
        int[][] dp = new int[nums.length][sum/2+1];
        return canPart(nums,0, sum/2, dp);
    }

    public static boolean canPart(int[] nums, int i, int target, int[][] dp){
        if(i>=nums.length || target<0) return false;
        if(target ==0) return true;
        if(dp[i][target]!=0) return dp[i][target]==1;
        if(canPart(nums,i+1, target,dp) || canPart(nums,i+1,target-nums[i],dp)){
            dp[i][target]=1;
            return true;
        }
        dp[i][target]=-1;
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1, 5, 11, 5};
        boolean result = canPartition(nums);
        System.out.println(result); // Output: true
    }
    
}
