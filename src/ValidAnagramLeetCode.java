public class ValidAnagramLeetCode {

    public static boolean isAnagram(String s, String t) {
        int[] freq1 = new int[26], freq2 = new int[26];
        if(s.length()!=t.length()) return false;
        for(int i=0;i<s.length();i++){
            freq1[s.charAt(i)-'a']++;
            freq2[t.charAt(i)-'a']++;
        }
        for(int i=0;i<freq1.length;i++){
            if(freq1[i]!=freq2[i]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        boolean result = isAnagram(s, t);
        System.out.println(result); // Output: true
    }
    
}
