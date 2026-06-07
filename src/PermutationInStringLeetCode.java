public class PermutationInStringLeetCode {

    public static boolean checkInclusion(String s1, String s2) {
        char[] s2c = s2.toCharArray();
        int[] count = new int[26];
        for (char c : s1.toCharArray()) count[c - 'a']++;
        int totalCount = s1.length();
        int l = 0, r = 0;
        while (l < s2c.length && r < s2c.length) {
            while (l<s2c.length && count[s2c[l] - 'a'] == 0) {
                l++;
                r++;
            }
            while (r < s2c.length && count[s2c[r] - 'a'] != 0) {
                count[s2c[r] - 'a']--;
                totalCount--;
                if (totalCount == 0)
                    return true;
                r++;
                while (l < r && r < s2c.length && count[s2c[r] - 'a'] == 0) {
                    count[s2c[l] - 'a']++;
                    totalCount++;
                    l++;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String s1 = "hello", s2 = "ooolleoooleh";
        System.out.println(checkInclusion(s1, s2));
        s1 = "ab";
        s2 = "eidboaoo";
        System.out.println(checkInclusion(s1, s2));
    }
    
}
