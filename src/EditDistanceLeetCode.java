public class EditDistanceLeetCode {

    public static int minDistance(String word1, String word2) {
        char[] w1 = word1.toCharArray(), w2 = word2.toCharArray();
        int m = word1.length() + 1, n = word2.length() + 1;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (w1[i - 1] == w2[j - 1])
                    dp[i][j] = dp[i - 1][j - 1];
                else
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        String word1 = "monkeys", word2 = "money";
        // System.out.println(minDistance(word1, word2));
        word1 = "neatcdee";
        word2 = "neetcode";
        System.out.println(minDistance(word1, word2));
    }

}
