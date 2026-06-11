import java.util.Arrays;

public class LongestIncreasingPathInMatrixLeetCode {

    public static int[][] dirns = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

    public static int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        if (m == 0)
            return 0;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        for (int[] dpRow : dp)
            Arrays.fill(dpRow, -1);
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int path = dfs(matrix, i, j, dp);
                res = Math.max(res, path);
            }
        }
        return res;
    }

    public static int dfs(int[][] matrix, int i, int j, int[][] dp) {
        int m = matrix.length, n = matrix[0].length;
        if (i >= m || j >= n)
            return 0;
        if (dp[i][j] != -1)
            return dp[i][j];
        int maxPath = 1;
        for (int[] dir : dirns) {
            int newi = i + dir[0];
            int newj = j + dir[1];
            if (newi >= m || newj >= n || newi < 0 || newj < 0)
                continue;
            int newVal = matrix[newi][newj];
            if (newVal > matrix[i][j]) {
                int path = 1 + dfs(matrix, newi, newj, dp);
                maxPath = Math.max(maxPath, path);
            }
        }
        dp[i][j] = maxPath;
        return maxPath;
    }

    public static void main(String[] args) {
        int[][] matrix = { { 9, 9, 4 }, { 6, 6, 8 }, { 2, 1, 1 } };
        System.out.println(longestIncreasingPath(matrix));
        matrix = new int[][] { { 3, 4, 5 }, { 3, 2, 6 }, { 2, 2, 1 } };
        System.out.println(longestIncreasingPath(matrix));
    }

}
