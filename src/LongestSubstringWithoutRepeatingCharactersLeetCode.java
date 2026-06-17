import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharactersLeetCode {

    public static int lengthOfLongestSubstring(String s) {
        int l=0,r=1,len=1,max=1,n=s.length();
        if(n==0) return 0;
        HashSet<Character> set = new HashSet();
        char[] st = s.toCharArray();
        set.add(st[l]);
        for(l=0;l<n;l++){
            while(r<n && !set.contains(st[r])){
                set.add(st[r]);
                len++;
                max=Math.max(max,len);
                r++;
            }
            set.remove(st[l]);
            len--;
        }
        return max;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }
    
}
