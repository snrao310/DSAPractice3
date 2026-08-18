public class NumberOf1BitsLeetCode {

    public static int hammingWeight(int n) {
        int k=1,res=0;
        for(int i=0;i<32;i++){
            if((n & k) !=0) res++;
            k=k<<1;
        }
        return res;
    }
    
    public static int hammingWeight2(int n) {
        int res =0;
        for(int i=0;i<32;i++){
            res+= n&1;
            n=n>>1;
        }
        return res;
    }

    public static void main(String[] args) {
        int n = 11;
        System.out.println(hammingWeight(n));
    }
}
