import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharactersLeetCode {

    public static int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int res = 0;
        for(int i=0,j=0;i<s.length() && j<s.length();){
            char new_letter = s.charAt(j);
            if(set.contains(new_letter)){
                set.remove(s.charAt(i));
                i++;
            }else{
                set.add(new_letter);
                res = Math.max(res, j-i+1);
                j++;
            }
        }
        return res;
    }

    public static void main(String[] args){
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }
}
