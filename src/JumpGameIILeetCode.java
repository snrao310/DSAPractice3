import java.util.Arrays;

public class JumpGameIILeetCode {

    public static int jump(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp,-1);
        return jumpDP(nums, 0,dp);
    }

    public static int jumpDP(int[] nums, int i, int[] dp){
        if(i>=nums.length-1){
            return 0;
        }
        if(dp[i]!=-1) return dp[i];
        int jumpVal = nums[i], res = Integer.MAX_VALUE-1;
        for(int ival = i+1;ival<=i+jumpVal && ival<nums.length;ival++){
            int jumps = jumpDP(nums,ival,dp)+1;
            res = Math.min(res, jumps);
        }
        dp[i]=res;
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,0,1,4};
        System.out.println(jump(nums));
    }
    
}
