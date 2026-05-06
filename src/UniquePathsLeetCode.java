import java.util.Arrays;

public class UniquePathsLeetCode {

    public static int paths=0;
    public static int[][] dirs = {{0,1},{1,0}};

    public static int uniquePaths(int m, int n){
        paths=0;
        int[][] dp = new int[m][n];
        for(int[] row:dp) Arrays.fill(row, -1);
        return calPaths(m,n,0,0,new boolean[m][n],dp);
    }

    public static int calPaths(int m, int n, int i, int j, boolean[][] visited, int[][] dp){
        if(i==m-1 && j==n-1){
            return 1;
        }
        if(i<0 ||i==m ||j<0||j==n){
            return 0;
        }
        if(dp[i][j]!=-1) return dp[i][j];
        if(visited[i][j]) return -1;
        visited[i][j]=true;
        int paths=0;
        for(int[] dir: dirs){
            int newPaths = calPaths(m, n, i+dir[0], j+dir[1], visited, dp);
            if(newPaths != -1) {
                paths += newPaths;
            }
        }
        dp[i][j]=paths;
        visited[i][j]=false;
        return paths;
    }

    public static void main(String[] args) {
        int m=3, n=6;
        System.out.println(uniquePaths(m,n));
        m=3; n=3;
        System.out.println(uniquePaths(m,n));
    }
    
}
