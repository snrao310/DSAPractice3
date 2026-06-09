import java.util.Arrays;

public class DistinctSubsequencesLeetCode {

    public static int numDistinct(String s, String t) {
        int[][] dp = new int[s.length()][t.length()];
        for (int[] dpRow : dp)
            Arrays.fill(dpRow, -1);
        return backtrack(s, t, 0, 0, dp);
    }

    public static int backtrack(String s, String t, int i, int j, int[][] dp){
        if(j==t.length()) return 1;
        if(i==s.length()) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int ways = 0;
        for(int k=i;k<s.length();k++){
            if(s.charAt(k)==t.charAt(j))
                ways+=backtrack(s, t, k+1, j+1, dp);
        }
        dp[i][j]=ways;
        return ways;
    }

    public static void main(String[] args) {
        System.out.println(numDistinct("rabbbit", "rabbit")); // 3
        System.out.println(numDistinct("babgbag", "bag")); // 5
    }

}
