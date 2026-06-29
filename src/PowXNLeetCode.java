public class PowXNLeetCode {

    public static double myPow(double x, int n) {
        // double res =1;
        // for(int i=0;i<n;i++){
        //     res*=x;
        // }
        // for(int i=0;i>n;i--){
        //     res*=(1.0/x);
        // }
        // return res;

        if(n<0){
            x=1/x;
            n*=-1;
        }
        if(x==0) return 0;
        if(n==0) return 1;
        if(n==1) return x;
        double pow = myPow(x,n/2);
        double leftOver= (n%2==1)?x:1;
        double res = pow*pow*leftOver;
        return res;
    }

    public static void main(String[] args) {
        System.out.println(myPow(2.0, 10));
        System.out.println(myPow(2.1, 3));
        System.out.println(myPow(2.0, -2));
    }
    
}
