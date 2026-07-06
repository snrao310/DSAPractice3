public class MaxAreaOfIslandLeetCode {
    public static int[][] dirns = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    public static int maxAreaOfIsland(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int res = 0;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && grid[i][j] == 1) {
                    int area = dfs(grid, i, j, visited);
                    res = Math.max(area, res);
                }
            }
        }
        return res;
    }

    public static int dfs(int[][] grid, int i, int j, boolean[][] visited) {
        int m = grid.length, n = grid[0].length;
        if (i < 0 || j < 0 || i >= m || j >= n)
            return 0;
        if (grid[i][j] == 0)
            return 0;
        if (visited[i][j])
            return 0;
        visited[i][j] = true;
        int area = 0;
        for (int[] dir : dirns) {
            area += dfs(grid, i + dir[0], j + dir[1], visited);
        }
        return area + 1;
    }

    public static void main(String[] args) {
        int[][] grid = { { 0, 1, 1, 0, 1 },
                { 1, 0, 1, 0, 1 },
                { 0, 1, 1, 0, 1 },
                { 0, 1, 0, 0, 1 }
        };
        System.out.println(maxAreaOfIsland(grid));
    }
}