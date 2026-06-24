public class WordSearchLeetCode {

    public static int[][] dirns = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};

    public static boolean exist(char[][] board, String word) {
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                char c = board[i][j];
                if(c==word.charAt(0)){
                    if(dfsFind(board, word.toCharArray(),0,i,j,new boolean[board.length][board[0].length]))
                        return true;
                }
            }
        }
        return false;
    }

    public static boolean dfsFind(char[][] board, char[] word, int ind, int i, int j, boolean[][] visited){
        if(ind == word.length) return true;
        if(i<0 || i>=board.length || j<0 || j>=board[0].length) return false;
        if(visited[i][j]) return false;
        if(word[ind]!=board[i][j]) return false;
        visited[i][j] = true;
        for(int[] dir: dirns){
            int ni = i+dir[0];
            int nj = j+dir[1];
            if(dfsFind(board, word, ind+1,ni,nj,visited)) return true;
        }
        visited[i][j]=false;
        return false;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };
        String word = "ABCCED";
        boolean result = exist(board, word);
        System.out.println(result); // Output: true
    }
    
}
