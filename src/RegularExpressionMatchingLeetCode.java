import java.util.Arrays;

public class RegularExpressionMatchingLeetCode {

    public static boolean isMatch(String s, String p) {
        int[][] dp = new int[s.length()+1][p.length()];
        for(int[] dpRow: dp) Arrays.fill(dpRow,-1);
        return backtrack(s.toCharArray(),p.toCharArray(),0,0,dp);
    }

    public static boolean backtrack(char[] s, char[] p, int i, int j, int[][] dp){
        if(i==s.length && j==p.length) return true;
        if(j==p.length) return false;
        if(dp[i][j]!=-1)return dp[i][j]==1;
        char sc = (i==s.length)?' ':s[i], pc = p[j];
        boolean nextStar = (j<p.length-1) && p[j+1]=='*';
        boolean result = false;
        if(!nextStar && (sc == pc || pc=='.')) result = backtrack(s, p, i+1, j+1, dp);
        else if(nextStar){
            int ival = i;
            while(ival<s.length && (s[ival]==pc || pc =='.')){
                if(backtrack(s, p, ival, j+2, dp)){
                    dp[i][j]=1;
                    return true;
                }
                ival++;
            }
            result = backtrack(s, p, ival, j+2, dp);
        }
        dp[i][j]=result?1:0;
        return result;
    }

    public static void main(String[] args) {
        System.out.println(isMatch("xyz", ".*z"));
        System.out.println(isMatch("aa", "a"));
        System.out.println(isMatch("aa", "a*"));
        System.out.println(isMatch("ab", ".*"));
        System.out.println(isMatch("aab", "c*a*b"));
        System.out.println(isMatch("mississippi", "mis*is*p*."));
    }
    
}
