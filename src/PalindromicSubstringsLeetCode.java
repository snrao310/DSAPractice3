
public class PalindromicSubstringsLeetCode {

    public static int countSubstrings(String s) {
        char[] st = s.toCharArray();
        int start = 0, end = 0, res = 0;
        for (int i = 0; i < 2 * st.length - 1; i++) {
            if (i % 2 == 0) {
                start = end = i / 2;
            } else {
                start = i / 2;
                end = start + 1;
            }
            while (start >= 0 && end < st.length && st[start] == st[end]) {
                res++;
                start--;
                end++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(countSubstrings("abc"));
        System.out.println(countSubstrings("aaa"));
    }
}
