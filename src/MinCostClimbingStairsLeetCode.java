import java.util.Arrays;

public class MinCostClimbingStairsLeetCode {

    public static int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length];
        Arrays.fill(dp,-1);
        return Math.min(minCostDp(cost,0,dp), minCostDp(cost,1,dp));
    }

    public static int minCostDp(int[] cost, int i, int[] dp){
        if(i>=cost.length) return 0;
        if(dp[i]!=-1) return dp[i];
        dp[i]=cost[i]+Math.min(minCostDp(cost,i+1,dp),minCostDp(cost,i+2,dp));
        return dp[i];
    }

    public static void main(String[] args) {
        int[] cost = {10, 15, 20};
        int result = minCostClimbingStairs(cost);
        System.out.println(result); // Output: 15
    }
    
}
