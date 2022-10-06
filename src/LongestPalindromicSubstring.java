public class LongestPalindromicSubstring {

    public static String longestPalindrome(String s) {
        int res_len = 0, res_start = 0, res_end = 0;
        for(int i=0;i<s.length()*2-2;i++){
            //odd index case (between the chars)
            int len =0,start = i/2,end=i/2+1;

            //even number case (the chars)
            if(i%2==0){
                len =1;
                start =i/2-1;
            }

            while(start>=0 && end<s.length()){
                if(s.charAt(start)==s.charAt(end)){
                    len+=2;
                    if(len>res_len){
                        res_len=len; res_start =start;res_end=end;
                    }
                    start--;end++;
                }
                else{
                    break;
                }
            }
        }
        return s.substring(res_start, res_end+1);
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("bb"));
    }
}
