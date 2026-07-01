import java.util.HashMap;
import java.util.HashSet;

public class MinimumWindowSubstringLeetCode {

    public static String minWindow(String s, String t) {
        if (s.length() < t.length())
            return "";
        HashMap<Character, Integer> countMap = new HashMap<>();
        HashSet<Character> letters = new HashSet<>();
        char[] ss = s.toCharArray(), tt = t.toCharArray();
        for (char c : tt) {
            countMap.put(c, countMap.getOrDefault(c, 0) + 1);
            letters.add(c);
        }
        int minLen = -1, minl = -1, minr = -1, l = 0, r = 0, n = s.length();
        while (l < n && r < n) {
            char cur = ss[r];
            if (countMap.containsKey(cur)) {
                countMap.put(cur, countMap.get(cur) - 1);
                if (countMap.get(cur) == 0) {
                    letters.remove(cur);
                    if (letters.isEmpty()) {
                        int len = r - l + 1;
                        if (len < minLen || minLen == -1) {
                            minLen = len;
                            minl = l;
                            minr = r;
                        }
                        while (l < n && l <= r && letters.isEmpty()) {
                            if (countMap.containsKey(ss[l])) {
                                len = r - l + 1;
                                if (len < minLen || minLen == -1) {
                                    minLen = len;
                                    minl = l;
                                    minr = r;
                                }
                                countMap.put(ss[l], countMap.get(ss[l]) + 1);
                                if (countMap.get(ss[l]) > 0)
                                    letters.add(ss[l]);
                            }
                            l++;
                        }
                    }
                }
            }
            r++;
        }
        if (minLen == -1)
            return "";
        return s.substring(minl, minr + 1);
    }

    public static void main(String[] args) {
        String s = "ab";
        String t = "b";
        System.out.println(minWindow(s, t));
    }

}
