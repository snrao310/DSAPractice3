import java.util.HashMap;
import java.util.HashSet;

public class MinimumWindowSubstringLeetCode {

    public static String minWindow(String s, String t) {
        int minI = 0, minJ=s.length(), i=0, j=0;
        char[] input = s.toCharArray(), target = t.toCharArray();
        HashMap<Character,Integer> charCount = new HashMap<Character, Integer>();
        HashSet<Character> toFind = new HashSet<Character>();
        for(char c: target){
            charCount.put(c,charCount.getOrDefault(c,0)+1);
            toFind.add(c);
        }
        while(j<input.length){
            char cur = input[j];
            if(!charCount.containsKey(cur)) {
                j++;
                continue;
            }
            charCount.put(cur,charCount.get(cur)-1);
            if(charCount.get(cur)==0){
                toFind.remove(cur);
            }
            while(toFind.isEmpty()){
                int subStringLen = j-i+1, minLen = minJ-minI+1;
                if(subStringLen<=minLen){
                    minI=i; minJ = j;
                }
                char iChar = input[i];
                if(charCount.containsKey(iChar)){
                    charCount.put(iChar,charCount.get(iChar)+1);
                    if(charCount.get(iChar)>0){
                        toFind.add(iChar);
                    }
                }
                i++;
            }
            j++;
        }
        if(minJ == s.length()) return "";
        return s.substring(minI,minJ+1);
    }

    public static void main(String args[]){
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
        System.out.println(minWindow("AABC", "ABC"));
        System.out.println(minWindow("AAABABACMQR", "AABC"));
        System.out.println(minWindow("AAABABACMQR", "MORK"));
        System.out.println(minWindow("A", "A"));
    }
}
