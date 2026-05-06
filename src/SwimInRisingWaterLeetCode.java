import java.util.Arrays;

public class SwimInRisingWaterLeetCode {

    public static int swimInWater(int[][] grid) {
        int n = grid.length, min=Integer.MAX_VALUE, max=Integer.MIN_VALUE;
        for(int[] mat:grid){
            for(int i:mat){
                min = Math.min(min, i);
                max = Math.max(max, i);
            }
        }
        int l=min, r=max;
        while(l<r){
            int m=(l+r)/2;
            if(canSwim(grid, m, new boolean[n][n], 0,0))r=m;
            else l=m+1;
        }
        return r;
    }

    public static boolean canSwim(int[][] grid, int min, boolean[][] visited, int i, int j){
        if(visited[i][j])return false;
        visited[i][j]=true;
        if(grid[i][j]>min) return false;
        int m = grid.length, n = grid[0].length;
        if(i==m-1 && j==n-1) return true;
        if(i<m-1 && canSwim(grid, min, visited, i+1, j)) return true;
        if(i>0 && canSwim(grid, min, visited, i-1, j)) return true;
        if(j<n-1 && canSwim(grid, min, visited, i, j+1)) return true;
        if(j>0 && canSwim(grid, min, visited, i, j-1)) return true;
        return false;
    }

    public static void main(String[] args) {
        int[][] grid = { { 0, 1 }, { 2, 3 } };
        // System.out.println(swimInWater(grid));
        grid = new int[][] { { 0, 1, 2, 10 },
                            { 9, 14, 4, 13 },
                            { 12, 3, 8, 15 },
                            { 11, 5, 7, 6 } };
        System.out.println(swimInWater(grid));
    }

}