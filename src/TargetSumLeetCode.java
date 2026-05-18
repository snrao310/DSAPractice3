import java.util.HashMap;

public class TargetSumLeetCode {

    public static int findTargetSumWays(int[] nums, int target) {
        HashMap<Integer,Integer>[] dp = (HashMap<Integer, Integer>[]) new HashMap[nums.length];
        return ways(nums,target, 0, dp);
    }

    public static int ways(int[] nums, int target, int i, HashMap<Integer, Integer>[] dp){
        if (i==nums.length-1) {
            if(target==0 && nums[i] ==0) return 2;
            return (target==nums[i] || target==-nums[i])?1:0;
        }
        if(dp[i]==null) dp[i] = new HashMap<>();
        if(dp[i].get(target)!=null) return dp[i].get(target);
        int ways = ways(nums, target-nums[i], i+1, dp) + ways(nums, target+nums[i], i+1, dp);
        dp[i].put(target,ways);
        return ways;
    }

    public static void main(String[] args) {
        int[] nums = {1,0};
        int target = 1;
        System.out.println(findTargetSumWays(nums, target));
    }
    
}
