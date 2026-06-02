import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WordSearchIILeetCode {

    public static int[][] dirns = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    public static class TrieNode {
        int numWords;
        String finishString;
        HashMap<Character, TrieNode> next;

        TrieNode() {
            this.next = new HashMap<>();
            this.finishString = null;
            this.numWords = 0;
        }
    }

    public static TrieNode constructTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            char[] w = word.toCharArray();
            TrieNode cur = root;
            for (char c : w) {
                if (!cur.next.containsKey(c)) {
                    cur.next.put(c, new TrieNode());
                }
                cur = cur.next.get(c);
                cur.numWords++;
            }
            cur.finishString = word;
        }
        return root;
    }

    public static List<String> findWords(char[][] board, String[] words) {
        TrieNode root = constructTrie(words);
        List<String> res = new ArrayList<>();
        int m = board.length;
        if (m == 0)
            return res;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char c = board[i][j];
                if (root.next.containsKey(c) && root.next.get(c).numWords != 0) {
                    backtrack(root.next.get(c), board, i, j, new boolean[m][n], res);
                }
            }
        }
        return res;
    }

    public static void backtrack(TrieNode cur, char[][] board, int i, int j, boolean[][] visited, List<String> res) {
        if (cur.finishString != null) {
            cur.numWords--;
            res.add(cur.finishString);
            cur.finishString = null;
        }
        visited[i][j] = true;
        int m = board.length, n = board[0].length;
        HashMap<Character, TrieNode> next = cur.next;
        for (int[] dir : dirns) {
            int nexti = i + dir[0];
            int nextj = j + dir[1];
            if (nexti >= 0 && nexti < m && nextj >= 0 && nextj < n && !visited[nexti][nextj]
                    && next.containsKey(board[nexti][nextj])) {
                TrieNode nextNode = next.get(board[nexti][nextj]);
                if (nextNode.numWords == 0)
                    continue;
                int words = nextNode.numWords;
                backtrack(nextNode, board, nexti, nextj, visited, res);
                if (words != nextNode.numWords) {
                    cur.numWords -= (words - nextNode.numWords);
                }
            }
        }
        visited[i][j] = false;
    }

    public static void main(String[] args) {
        char[][] board = { { 'a', 'b', 'c', 'd' }, { 's', 'a', 'a', 't' }, { 'a', 'c', 'k', 'e' },
                { 'a', 'c', 'd', 'n' } };
        String[] words = { "bat", "cat", "back", "backend", "stack" };
        List<String> result = findWords(board, words);
        for (String s : result) {
            System.out.print(s + " ");
        }
        board = new char[][] { { 'x', 'o' }, { 'x', 'o' } };
        words = new String[] { "xoxo" };
        System.out.println();
        result = findWords(board, words);
        for (String s : result) {
            System.out.print(s + " ");
        }
        board = new char[][] { { 'o', 'a', 'b', 'n' }, { 'o', 't', 'a', 'e' }, { 'a', 'h', 'k', 'r' },
                { 'a', 'f', 'l', 'v' } };
        words = new String[] { "oa", "oaa" };
        System.out.println();
        result = findWords(board, words);
        for (String s : result) {
            System.out.print(s + " ");
        }
    }

}
