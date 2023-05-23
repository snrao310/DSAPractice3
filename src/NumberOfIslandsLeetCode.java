import java.util.Arrays;

public class NumberOfIslandsLeetCode {

    static int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static int numIslands(char[][] grid) {
        if (grid.length == 0) return 0;
        int m = grid.length, n = grid[0].length, numIslands = 0;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '0') continue;
                if (visited[i][j]) continue;
                numIslands++;
                DFS(grid, visited, i, j);
            }
        }
        return numIslands;
    }

    private static void DFS(char[][] grid, boolean[][] visited, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) return;
        if (grid[i][j] == '0') return;
        if (visited[i][j]) return;

        visited[i][j] = true;
        for (int[] dir : dirs) {
            DFS(grid, visited, i + dir[0], j + dir[1]);
        }
    }

    public static void main(String args[]) {
        char[][] grid = new char[][]{{'1', '1', '0', '0'}, {'0', '0', '1', '1'}, {'0', '1', '0', '0'}};
        System.out.println(numIslands(grid));
    }
}
