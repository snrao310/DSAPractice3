import java.util.Arrays;

public class LongestCommonSubsequenceLeetCode {

    public static int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length()][text2.length()];
        for(int[] dpRow: dp) Arrays.fill(dpRow,-1);
        char[] t1 = text1.toCharArray(), t2 = text2.toCharArray();
        return lcs(t1,t2,0,0,dp);
    }

    public static int lcs(char[] t1, char[] t2, int i, int j, int[][] dp){
        if(i==t1.length || j==t2.length) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        if(t1[i]==t2[j]) dp[i][j]= lcs(t1,t2,i+1,j+1,dp)+1;
        else dp[i][j] = Math.max(lcs(t1,t2,i+1,j,dp), lcs(t1,t2,i,j+1,dp));
        return dp[i][j];
    }
    
    public static void main(String[] args) {
        System.out.println(longestCommonSubsequence("abcde", "ace"));
    }
    
}
