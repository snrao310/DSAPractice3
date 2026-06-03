import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class NQueensLeetCode {

    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        backtrack(new HashSet<Integer>(), new HashSet<Integer>(), new HashSet<Integer>(), new LinkedList<>(), res, 0, n);
        return res;
    }

    public static void backtrack(HashSet<Integer> cols, HashSet<Integer> posDiag, HashSet<Integer> negDiag,
            List<String> curList, List<List<String>> res, int curRow, int n) {
        
        if(curRow==n){
            res.add(new ArrayList<>(curList));
            return;
        }

        char[] row = new char[n];
        Arrays.fill(row, '.');
        for (int i = 0; i < n; i++) {
            if (!cols.contains(i) && !negDiag.contains(curRow + i) && !posDiag.contains(curRow - i)) {
                cols.add(i);
                negDiag.add(curRow + i);
                posDiag.add(curRow - i);
                row[i] = 'Q';
                String rowString = String.valueOf(row);
                curList.add(rowString);
                backtrack(cols, posDiag, negDiag, curList, res, curRow + 1, n);
                cols.remove(i);
                negDiag.remove(curRow + i);
                posDiag.remove(curRow - i);
                row[i]='.';
                curList.removeLast();
            }
        }
    }

    public static void main() {
        int n = 4;
        List<List<String>> res = solveNQueens(n);
        for (List<String> list : res) {
            for (String s : list) {
                System.out.println(s);
            }
            System.out.println();
        }
    }

}
