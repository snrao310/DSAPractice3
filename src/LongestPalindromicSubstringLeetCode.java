public class LongestPalindromicSubstringLeetCode {

    public static String longestPalindrome(String s) {
        int n = s.length(), max = 0, lsel = 0, rsel = 0;
        for (int i = 0; i < n; i++) {
            int l = i, r = i, len = 0;
            while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                len += l == r ? 1 : 2;
                l--;
                r++;
            }
            if (len > max) {
                max = len;
                lsel = l + 1;
                rsel = r - 1;
            }
            System.out.println(max);

            l = i;
            r = i + 1;
            len = 0;
            while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                len += 2;
                l--;
                r++;
                ;
            }
            if (len > max) {
                max = len;
                lsel = l + 1;
                rsel = r - 1;
            }
        }
        return s.substring(lsel, rsel + 1);
    }

    public static void main(String[] args) {
        String s = "babad";
        System.out.println(longestPalindrome(s));
    }

}
