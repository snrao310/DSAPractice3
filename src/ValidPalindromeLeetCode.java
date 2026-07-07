public class ValidPalindromeLeetCode {
    
    public static boolean isPalindrome(String s) {
        char[] st = s.toCharArray();
        int l=0,r=st.length-1;
        while(l<r){
            while(!Character.isLetterOrDigit(st[l]) && l<r){
                l++;
            }
            while(!Character.isLetterOrDigit(st[r]) && l<r){
                r--;
            }
            if(Character.isLetter(st[l])) st[l] = Character.toLowerCase(st[l]);
            if(Character.isLetter(st[r])) st[r] = Character.toLowerCase(st[r]);
            if(st[l]!=st[r]) return false;
            l++;
            r--;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        boolean result = isPalindrome(s);
        System.out.println(result); // Output: true
    }
    
}
