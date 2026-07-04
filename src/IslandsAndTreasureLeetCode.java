import java.util.LinkedList;
import java.util.Queue;

public class IslandsAndTreasureLeetCode {

    public static int[][] dirns = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    public static void islandsAndTreasure(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j]==0) {
                    queue.add(new int[]{i,j});
                    visited[i][j]=true;
                }
            }
        }
        queue.add(null);
        int dis = 0;
        while(!queue.isEmpty()){
            int[] e = queue.poll();
            if(e==null){
                if(!queue.isEmpty()) queue.add(null);
                dis++;
                continue;
            }
            int i = e[0], j=e[1];
            grid[i][j]=dis;
            for(int[] dir: dirns){
                int ni = i+dir[0],nj = j+dir[1];
                if(ni>=0 && ni<m && nj>=0 && nj<n){
                    if(visited[ni][nj]) continue;
                    if(grid[ni][nj]==0||grid[ni][nj]==-1) continue;
                    visited[ni][nj]=true;
                    queue.add(new int[]{ni,nj});
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] grid = {
                {2147483647,-1,0,2147483647},
                {2147483647,2147483647,2147483647,-1},
                {2147483647,-1,2147483647,-1},
                {0,-1,2147483647,2147483647},
        };

        islandsAndTreasure(grid);

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }
    
}
