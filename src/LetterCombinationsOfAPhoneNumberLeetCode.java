import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LetterCombinationsOfAPhoneNumberLeetCode {

    public static List<String> letterCombinations(String digits) {
        String[] digitStrings = new String[] { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
        return letterCombBacktrack(digits.toCharArray(), 0, digitStrings);
    }

    public static List<String> letterCombBacktrack(char[] dig, int i, String[] digitStrings) {
        List<String> res = new ArrayList<>();
        if (dig.length == 0)
            return res;
        char cur = dig[i];
        String t = digitStrings[cur - '0'];
        String[] s = t.split("");
        if (i == dig.length - 1) {
            return Arrays.asList(s);
        }
        List<String> nextRes = letterCombBacktrack(dig, i + 1, digitStrings);
        for (String c : s) {
            for (String n : nextRes) {
                res.add(c + n);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String digits = "34";
        for (String s : letterCombinations(digits)) {
            System.out.print(s + " ");
        }
        System.out.println();
    }

}
