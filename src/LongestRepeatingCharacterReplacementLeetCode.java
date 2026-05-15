import java.util.HashMap;

public class LongestRepeatingCharacterReplacementLeetCode {

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
        String s = "KRSCDCSONAJNHLBMDQGIFCPEKPOHQIHLTDIQGEKLRLCQNBOHNDQGHJPNDQPERNFSSSRDEQLFPCCCARFMDLHADJADAGNNSBNCJQOF";
        int k = 4;
        System.out.println(characterReplacement(s, k));
    }
    
}
