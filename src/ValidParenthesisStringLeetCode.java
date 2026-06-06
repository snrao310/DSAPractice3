public class ValidParenthesisStringLeetCode {

    public static boolean checkValidString(String s) {
        int leftOpenMin =0, leftOpenMax = 0;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c=='('){
                leftOpenMin++;
                leftOpenMax++;
            }
            else if(c==')'){
                leftOpenMin--;
                leftOpenMax--;
            }
            else{
                leftOpenMin--;
                leftOpenMax++;
            }
            leftOpenMin= Math.max(leftOpenMin,0);
            if(leftOpenMax<0) return false;
        }
        return leftOpenMin==0;
    }

    public static void main(String[] args) {
        String s = "()";
        System.out.println(checkValidString(s));
        s = "(*)";
        System.out.println(checkValidString(s));
        s = "(*))";
        System.out.println(checkValidString(s));
    }
    
}
