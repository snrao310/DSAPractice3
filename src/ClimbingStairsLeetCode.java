public class ClimbingStairsLeetCode {

    public static int climbStairs(int n) {
        int[] dp = new int[n+1];
        for(int i=0;i<n+1;i++){
            if(i<=2){
                dp[i]=i;
                continue;
            }
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println(climbStairs(n));
    }
    
}
