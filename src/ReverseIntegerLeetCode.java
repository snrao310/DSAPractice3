public class ReverseIntegerLeetCode {

    public static int reverse(int x) {
        int res = 0;
        boolean isNeg = false;
        if(x<0) {
            isNeg =true;
            x=-x;
        }
        while(x!=0){
            int num = x%10;
            x=x/10;
            if(res>Integer.MAX_VALUE/10) return 0;
            res*=10;
            if(res>Integer.MAX_VALUE-num) return 0;
            res+=num;
        }
        return isNeg?-res:res;
    }

    public static void main(String[] args) {
        int x = 123;
        System.out.println(reverse(x));
        x=-123;
        System.out.println(reverse(x));
        x=120;
        System.out.println(reverse(x));
    }
    
}
