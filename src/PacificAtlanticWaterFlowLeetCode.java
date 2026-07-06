import java.util.ArrayList;
import java.util.List;

public class PacificAtlanticWaterFlowLeetCode {

    public static int[][] dirns = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    public static List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        List<List<Integer>> res = new ArrayList<>();
        boolean[][] pacific = new boolean[m][n], atlantic = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            if (!pacific[i][0]) {
                dfs(heights, i, 0, pacific);
            }
            if (!atlantic[i][n - 1]) {
                dfs(heights, i, n - 1, atlantic);
            }
        }
        for (int j = 0; j < n; j++) {
            if (!pacific[0][j]) {
                dfs(heights, 0, j, pacific);
            }
            if (!atlantic[m - 1][j]) {
                dfs(heights, m - 1, j, atlantic);
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    res.add(List.of(i, j));
                }
            }
        }
        return res;
    }

    public static void dfs(int[][] heights, int i, int j, boolean[][] reachable) {
        int m = heights.length, n = heights[0].length;
        if (reachable[i][j])
            return;
        reachable[i][j] = true;
        for (int[] dir : dirns) {
            int ni = i + dir[0], nj = j + dir[1];
            if (ni < 0 || ni >= m || nj < 0 || nj >= n)
                continue;
            if (heights[ni][nj] >= heights[i][j])
                dfs(heights, ni, nj, reachable);
        }
    }

    public static void main(String[] args) {
        int[][] heights = { { 4, 2, 7, 3, 4 },
                { 7, 4, 6, 4, 7 },
                { 6, 3, 5, 3, 6 } };
        System.out.println(pacificAtlantic(heights));
    }

}
