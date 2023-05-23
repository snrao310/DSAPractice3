import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SpiralMatrixLeetCode {

    public static List<Integer> spiralOrder(int[][] matrix) {
        ArrayList res =  new ArrayList();
        if(matrix.length==0) return res;
        int mStart = 0, nStart = 0, mEnd = matrix.length-1, nEnd = matrix[0].length-1;
        while(mStart<= mEnd && nStart<=nEnd){
            for(int j=nStart;j<=nEnd;j++){
                res.add(matrix[mStart][j]);
            }
            for(int i=mStart+1;i<=mEnd;i++){
                res.add(matrix[i][nEnd]);
            }
            for(int j=nEnd-1;j>=nStart && mStart!=mEnd;j--){
                res.add(matrix[mEnd][j]);
            }
            for(int i=mEnd-1;i>mStart && nStart!=nEnd;i--){
                res.add(matrix[i][nStart]);
            }
            mStart++;mEnd--;
            nStart++;nEnd--;
        }
        return res;
    }

    public static void main(String args[]){
        List<Integer> res = spiralOrder(new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}});
        System.out.println(res.toString());
        res = spiralOrder(new int[][]{{1,2,3},{4,5,6},{7,8,9}});
        System.out.println(res.toString());
        res = spiralOrder(new int[][]{});
        System.out.println(res.toString());
        res = spiralOrder(new int[][]{{1}});
        System.out.println(res.toString());
        res = spiralOrder(new int[][]{{1,2,3}});
        System.out.println(res.toString());

    }
}
