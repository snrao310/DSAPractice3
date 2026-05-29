public class PlusOneLeetCode {

    public static void main(String[] args) {
        int[] digits = {9, 9, 9};
        int[] result = plusOne(digits);
        for (int digit : result) {
            System.out.print(digit + " ");
        }
    }
    public static int[] plusOne(int[] digits) {
        int carry =1;
        for(int i=digits.length-1;i>=0;i--){
            if(digits[i] == 9 && carry==1)
                digits[i]=0;
            else {
                digits[i]=digits[i]+1;
                carry=0;
                break;
            }
        }
        if(carry==0)return digits;
        int[] res= new int[digits.length+1];
        res[0] = 1;
        for(int i=1;i<res.length;i++){
            res[i]=digits[i-1];
        }
        return res;
    }
    
}
