public class CountingBitsLeetCode {

    public static int[] countBits(int n) {
        int i=0,pow = 2;
        int[] res = new int[n+1];
        while(i<n+1){
            if(i==0 || i==1) {
                res[i]=i;
                i++;
                continue;
            }
            pow *= 2;
            int j=0;
            while(i<pow && i<n+1){
                res[i]=res[j]+1;
                i++;j++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int n = 5;
        int[] res = countBits(n);
        for(int i=0;i<res.length;i++){
            System.out.print(res[i]+" ");
        }
    }
    
}
