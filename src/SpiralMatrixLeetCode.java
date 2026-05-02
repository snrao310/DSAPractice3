import java.util.LinkedList;
import java.util.List;

public class SpiralMatrixLeetCode {

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new LinkedList<>();
        if (matrix.length == 0)
            return res;
        int m = matrix.length, n = matrix[0].length;
        int startrow = 0, endrow = m - 1, startcol = 0, endcol = n - 1;
        while (startrow <= endrow && startcol <= endcol) {
            for (int i = startcol; i <= endcol; i++) {
                res.add(matrix[startrow][i]);
            }
            for (int i = startrow + 1; i <= endrow; i++) {
                res.add(matrix[i][endcol]);
            }
            if (startrow != endrow) {
                for (int i = endcol - 1; i >= startcol; i--) {
                    res.add(matrix[endrow][i]);
                }
            }
            if (startcol != endcol) {
                for (int i = endrow - 1; i >= startrow + 1; i--) {
                    res.add(matrix[i][startcol]);
                }
            }
            startrow++;
            startcol++;
            endrow--;
            endcol--;
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        List<Integer> res = spiralOrder(matrix);
        for (int i : res) {
            System.out.print(i + " ");
        }
        matrix = new int[][] { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
        res = spiralOrder(matrix);
        System.out.println();
        for (int i : res) {
            System.out.print(i + " ");
        }
        matrix = new int[][] { { 1 } };
        res = spiralOrder(matrix);
        System.out.println();
        for (int i : res) {
            System.out.print(i + " ");
        }
    }

}
