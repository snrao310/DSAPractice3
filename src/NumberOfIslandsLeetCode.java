public class NumberOfIslandsLeetCode {

    public static int[][] dirns = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};

    public static int numIslands(char[][] grid) {
        if(grid.length==0) return 0;
        int m = grid.length, n=grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int islands = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='0') continue;
                if(visited[i][j]) continue;
                dfs(i,j, grid, visited);
                islands++;
            }
        }
        return islands;
    }

    public static void dfs(int i, int j, char[][] grid, boolean[][] visited){
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length) return;
        if(grid[i][j]=='0') return;
        if(visited[i][j]) return;
        visited[i][j] = true;
        for(int[] dir: dirns){
            dfs(i+dir[0],j+dir[1],grid,visited);
        }
    }


    public static void main(String[] args) {
        char[][] grid = { { '1', '1', '0', '0', '0' }, { '1', '1', '0', '0', '0' }, { '0', '0', '1', '0', '0' },
                { '0', '0', '0', '1', '1' } };
        System.out.println(numIslands(grid));
    }
    
}
