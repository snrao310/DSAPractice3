public class SearchA2DMatrixLeetCode {

    public static boolean searchMatrix(int[][] matrix, int target) {
        int l=0,r=matrix.length-1;
        while(l<=r){
            int m=(l+r)/2;
            if(matrix[m][0]==target) return true;
            else if(matrix[m][0]>target) r=m-1;
            else l=m+1;
        }
        if(r>=matrix.length || r<0) return false;
        int row = r;
        l=0;r=matrix[row].length-1;
        while(l<=r){
            int m=(l+r)/2;
            if(matrix[row][m]==target) return true;
            else if(matrix[row][m]>target) r=m-1;
            else l=m+1;
        }
        return false;
    }


    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
            int target = 3;
            System.out.println(searchMatrix(matrix, target));
        matrix = new int[][]{{1},{3}};
        target = 3;
        System.out.println(searchMatrix(matrix, target));
    }
    
}
