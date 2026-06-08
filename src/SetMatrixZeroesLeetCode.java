import java.util.Arrays;

public class SetMatrixZeroesLeetCode {

    public void setZeroes(int[][] matrix) {
        boolean firstRowZero=false,firstColZero=false;
        int m=matrix.length,n=matrix[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==0){
                    matrix[0][j]=0;
                    matrix[i][0]=0;
                    if(i==0) firstRowZero=true;
                    if(j==0) firstColZero=true;
                }
            }
        }
        for(int i=1;i<m;i++){
            if(matrix[i][0]==0){
                Arrays.fill(matrix[i],0);
            }
        }
        for(int j=1;j<n;j++){
            if(matrix[0][j]==0){
                for(int k=0;k<m;k++){
                    matrix[k][j]=0;
                }
            }
        }
        if(matrix[0][0]==0){
            if(firstRowZero)Arrays.fill(matrix[0],0);
            if(firstColZero){
                for(int k=0;k<m;k++){
                    matrix[k][0]=0;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = { { 1, 1, 1 }, { 1, 0, 1 }, { 1, 1, 1 } };
        SetMatrixZeroesLeetCode solution = new SetMatrixZeroesLeetCode();
        solution.setZeroes(matrix);
        for (int[] row : matrix) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
    
}
