public class SumOfTwoIntegersLeetCode {

    public static int getSum(int a, int b) {
        int sum = a, carry = b;
        while(carry!=0){
            int newsum = sum^carry;
            carry = (sum&carry)<<1;
            sum = newsum;
        }
        return sum;
    }

    public static void main(String[] args) {
        int a = 1, b = 2;
        System.out.println(getSum(a, b));
        a = 2;
        b = 3;
        System.out.println(getSum(a, b));
    }
    
}
