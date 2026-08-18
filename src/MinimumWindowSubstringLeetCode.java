import java.util.HashMap;
import java.util.HashSet;

public class MinimumWindowSubstringLeetCode {

    public static String minWindowOld(String s, String t) {
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

    public static String minWindow(String s, String t) {
        int found = 0, i = 0, l = 0, r = 0, slen = s.length(), tlen = t.length();
        char[] st = s.toCharArray(), tt = t.toCharArray();
        int[] freq = new int[60];
    HashSet<Character> tset = new HashSet<>();
    for (char c : tt) {
            freq[c - 'A']++;
            tset.add(c);
        }
        while (i<slen && !tset.contains(st[i])) i++;
        if (i == slen)
            return "";
        l = i;
        r = i;
        freq[st[i] - 'A']--;
        found = 1;
        int minLen = Integer.MAX_VALUE, minl=0,minr=0;
        while (r < slen && l< slen) {
            while (found != tlen && r < slen-1) {
                r++;
                if (tset.contains(st[r])) {
                    freq[st[r] - 'A']--;
                    if (freq[st[r] - 'A'] >= 0)
                        found++;
                }
            }
            if (found == tlen){
                int len = r - l + 1;
                if(len<minLen){
                    minLen = len;
                    minl=l;
                    minr=r;
                }
            }
            if (r == slen-1 && found != tlen)
                break;
            while (l < r && (!tset.contains(st[l]) || freq[st[l]-'A']<0)) {
                if(tset.contains(st[l])){
                    freq[st[l]-'A']++;
                }
                l++;
            }
            if (found == tlen){
                int len = r - l + 1;
                if(len<minLen){
                    minLen = len;
                    minl=l;
                    minr=r;
                }
                freq[st[l] - 'A']++;
                found--;
                l++;
            }
        }
        if(minLen==Integer.MAX_VALUE) return "";
        return s.substring(minl,minr+1);
    }



    public static void main(String[] args) {
        String s = "ab";
        String t = "b";
        System.out.println(minWindow(s, t));
    }

}
