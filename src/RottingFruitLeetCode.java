import java.util.LinkedList;
import java.util.Queue;

public class RottingFruitLeetCode {

    public static int[][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};

    public static void main(String[] args) {
        int[][] grid = {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        System.out.println(orangesRotting(grid));
    }

    public static int orangesRotting(int[][] grid) {
        int m = grid.length;
        if(m==0) return -1;
        int n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        boolean visited[][] = new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2){
                    visited[i][j]=true;
                    queue.add(new int[]{i,j});
                }
            }
        }
        queue.add(null);
        int minute = -1;
        //bfs
        while(!queue.isEmpty()){
            int[] element = queue.poll();
            if(element==null){
                minute++;
                if(!queue.isEmpty()){
                    queue.add(null);
                }
                continue;
            }
            for(int[] dir: dirs){
                int i=element[0];
                int j=element[1];
                int newi = i+dir[0];
                int newj = j+dir[1];
                if(newi>=0&&newi<m&&newj>=0&&newj<n&&!visited[newi][newj]&&grid[newi][newj]==1){
                    visited[newi][newj]=true;
                    grid[newi][newj]=2;
                    queue.add(new int[]{newi,newj});
                }
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    return -1;
                }
            }
        }
        return minute;
    }
    
}
