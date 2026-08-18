
public class LongestRepeatingCharacterReplacementLeetCode {

    public static int characterReplacement2(String s, int k) {
        char[] st = s.toCharArray();
        int[] freq = new int[26];
        int len = 1, l = 0, r = 0, n = st.length, replaced = 0, res = 1;
        freq[st[0] - 'A']++;
        while (r < n - 1) {
            while (r < n - 1 && replaced <= k) {
                r++;
                len++;
                freq[st[r] - 'A']++;
                replaced = getNewReplaced(freq, len);
                if(replaced<=k)
                res = Math.max(res, len);
            }
            while (l < r && replaced > k) {
                freq[st[l] - 'A']--;
                l++;
                len--;
                replaced = getNewReplaced(freq, len);
            }
        }
        return res;
    }

    public static int getNewReplaced(int[] freq, int len) {
        int max = 0;
        for (int val : freq) {
            max = Math.max(max, val);
        }
        return len - max;
    }

    public static int characterReplacement(String s, int k) {
        char[] st = s.toCharArray();
        int[] freq = new int[26];
        int res = 0, max=0,len =0;
        for(int i=0;i<st.length;i++){
            freq[st[i]-'A']+=1;
            len++;
            max=Math.max(max,freq[st[i]-'A']);
            int replaced = len-max;
            int j=i-len+1;
            while(replaced>k && j<=i){
                len--;
                freq[st[j]-'A']-=1;
                max=0;
                for(int val:freq){
                    max=Math.max(max,val);
                }
                replaced = len-max;
                j++;
            }
            res=Math.max(len,res);
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "ABCDZZZ";
        int k = 3;
        System.out.println(characterReplacement(s, k));
    }
    
}
