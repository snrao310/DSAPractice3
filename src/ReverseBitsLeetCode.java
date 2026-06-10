public class ReverseBitsLeetCode {

    public static int reverseBits(int n) {
        int res = 0;
        for(int i=0;i<32;i++){
            int bit = (n>>i) & 1;
            res += (bit<<(31-i));
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(reverseBits(43261596));
        System.out.println(reverseBits(1));
    }
    
}
