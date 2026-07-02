public class SurroundedRegionsLeetCode {

    public static int[][] dirns = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};

    public static void solve(char[][] board) {
        if (board.length <= 1)
            return;
        if (board[0].length <= 1)
            return;
        int m = board.length, n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            if (!visited[i][0])
                dfs(i, 0, board, visited);
            if (!visited[i][n - 1])
                dfs(i, n - 1, board, visited);
        }
        for (int j = 0; j < n; j++) {
            if (!visited[0][j])
                dfs(0, j, board, visited);
            if (!visited[m - 1][j])
                dfs(m - 1, j, board, visited);
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!visited[i][j]){
                    board[i][j]='X';
                }
            }
        }
    }

    public static void dfs(int i, int j, char[][] board, boolean[][] visited) {
        if(i<0 || j<0 || i>=board.length || j>=board[0].length) return;
        if(board[i][j]=='X') return;
        if(visited[i][j]) return;
        visited[i][j] = true;
        for(int[] dir: dirns){
            dfs(i+dir[0], j+dir[1], board, visited);
        }
    }

    public static void main(String[] args) {
        char[][] board = {
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}
        };
        solve(board);
        for (char[] row : board) {
            for (char c : row) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }

}
