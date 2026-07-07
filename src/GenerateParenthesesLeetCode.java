import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesesLeetCode {
    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList();
        backtrack(n, 0, new StringBuilder(), res);
        return res;
    }

    public static  void backtrack(int n, int open, StringBuilder sb, List<String> res) {
        if (n == 0 && open == 0) {
            res.add(sb.toString());
            return;
        }
        if (n > 0) {
            sb.append("(");
            backtrack(n - 1, open + 1, sb, res);
            sb.setLength(sb.length() - 1);
        }
        if (sb.length() != 0 && open != 0) {
            sb.append(")");
            backtrack(n, open - 1, sb, res);
            sb.setLength(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        List<String> res = generateParenthesis(3);
        System.out.println(res);
    }
}
