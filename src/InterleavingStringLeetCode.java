public class InterleavingStringLeetCode {

    public static boolean isInterleave(String s1, String s2, String s3) {
        if(s3.length()!=s1.length()+s2.length()) return false;
        int[][] dp = new int[s1.length()+1][s2.length()+1];
        return backtrack(s1.toCharArray(), 0, s2.toCharArray(), 0, s3.toCharArray(), 0,dp);
    }

    public static boolean backtrack(char[] s1, int i, char[] s2, int j, char[] s3, int k,int[][] dp) {
        if (k == s3.length) {
            if (i == s1.length && j == s2.length)
                return true;
            else
                return false;
        }
        if(dp[i][j]!=0) return dp[i][j]==1;
        if (j < s2.length && s2[j] == s3[k]) {
            if (backtrack(s1, i, s2, j + 1, s3, k + 1,dp)){
                dp[i][j]=1;
                return true;
            }
        }
        if (i < s1.length && s1[i] == s3[k]) {
            if (backtrack(s1, i + 1, s2, j, s3, k + 1,dp)){
                dp[i][j]=1;
                return true;
            }
        }
        dp[i][j]=-1;
        return false;
    }

    public static void main(String[] args) {
        String s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac";
        System.out.println(isInterleave(s1, s2, s3));
        s1 = "aabcc";
        s2 = "dbbca";
        s3 = "aadbbbaccc";
        System.out.println(isInterleave(s1, s2, s3));
    }
    
}
