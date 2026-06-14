import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioningLeetCode {

    public static List<List<String>> partition(String s) {
        List<List<String>>[] dp = new List[s.length()];
        return backtrack(s, 0, dp);
    }

    public static List<List<String>> backtrack(String s, int start, List<List<String>>[] dp) {
        List<List<String>> res = new ArrayList<>();
        if (start == s.length()) {
            res.add(new ArrayList<>());
            return res;
        }
        if (dp[start] != null)
            return new ArrayList<>(dp[start]);
        for (int i = start; i < s.length(); i++) {
            if (isPalindrome(s.substring(start, i+1))) {
                List<List<String>> list = backtrack(s, i + 1, dp);
                for (List<String> l : list) {
                    List<String> newList = new ArrayList<>(l);
                    newList.addFirst(s.substring(start, i+1));
                    res.add(newList);
                }
            }
        }
        dp[start] = res;
        return new ArrayList<>(res);
    }

    public static boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j))
                return false;
            i++;j--;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "aab";
        List<List<String>> res = partition(s);
        for (List<String> list : res) {
            for (String str : list)
                System.out.print(str + " ");
            System.out.println();
        }
    }

}
