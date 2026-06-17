import java.util.Arrays;

public class DecodeWaysLeetCode {

    public static int numDecodings(String s) {
        int[] dp = new int[s.length()];
        Arrays.fill(dp, -1);
        return backtrack(s.toCharArray(), 0, dp);
    }

    public static int backtrack(char[] s, int i, int[] dp) {
        if (i == s.length)
            return 1;
        if (s[i] == '0')
            return 0;
        if (dp[i] != -1)
            return dp[i];
        int res = backtrack(s, i + 1, dp);
        if (i < s.length - 1 && (s[i] <= '1' || (s[i] <= '2' && s[i + 1] <= '6')))
            res += backtrack(s, i + 2, dp);
        dp[i] = res;
        return res;
    }

    public static void main(String[] args) {
        String s = "2611055971756562";
        System.out.println(numDecodings(s));
    }

}
