public class PalindromicSubstringsLeetCode {

    public static int countSubstrings(String s){
        char[] str = s.toCharArray();
        int res =0, start=0, end=0, j=0;
        for(int i=0;i<str.length*2-1;i++){
            j=0;
            if(i%2==0){
                 start = i/2; end = i/2;
            }
            else{
                 start = i/2; end = i/2+1;
            }
            while(start-j>=0 && end+j<str.length &&str[start-j]==str[end+j]){
                j++;res++;
            }
        }
        return res;
    }

    public static void main(String[] args){
        System.out.println(countSubstrings("abc"));
        System.out.println(countSubstrings("aaa"));
    }
}
