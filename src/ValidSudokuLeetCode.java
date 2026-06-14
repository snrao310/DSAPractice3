import java.util.HashMap;
import java.util.HashSet;

public class ValidSudokuLeetCode {

    public boolean isValidSudoku(char[][] board) {
        int m = board.length, n = board[0].length;
        if (m != 9 || n != 9)
            return false;
        HashMap<Integer, HashSet<Integer>> rowMap = new HashMap<>(), colMap = new HashMap<>(), boxMap = new HashMap<>();
        for (int i = 0; i < 9; i++) {
            rowMap.put(i, new HashSet<>());
            colMap.put(i, new HashSet<>());
            boxMap.put(i, new HashSet<>());
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                int val = board[i][j];
                if (val == '.')
                    continue;
                if (rowMap.get(i).contains(val))
                    return false;
                if (colMap.get(j).contains(val))
                    return false;
                int box = j / 3 + i / 3 * 3;
                if (boxMap.get(box).contains(val))
                    return false;
                rowMap.get(i).add(val);
                colMap.get(j).add(val);
                boxMap.get(box).add(val);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] board = {
                { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
                { '6', '.', '.', '1', '9', '5', '.', '.', '.' },
                { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
                { '8', '.', '.', '.', '6', '.', '.', '.', '3' },
                { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
                { '7', '.', '.', '.', '2', '.', '.', '.', '6' },
                { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
                { '.', '.', '.', '4', '1', '9', '.', '.', '5' },
                { '.', '.', '.', '.', '8', '.', '.', '7', '9' }
        };
        ValidSudokuLeetCode sol = new ValidSudokuLeetCode();
        System.out.println(sol.isValidSudoku(board));
        board = new char[][] {
                { '8', '3', '.', '.', '7', '.', '.', '.', '.' },
                { '6', '.', '.', '1', '9', '5', '.', '.', '.' },
                { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
                { '8', '.', '.', '.', '6', '.', '.', '.', '3' },
                { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
                { '7', '.', '.', '.', '2', '.', '.', '.', '6' },
                { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
                { '.', '.', '.', '4', '1', '9', '.', '.', '5' },
                { '.', '.', '.', '.', '8', '.', '.', '7', '9' }
        };
        System.out.println(sol.isValidSudoku(board));
    }

}
