public class ZigzagConversionLeetCode {

    public static String convert(String s, int numRows) {
        if(numRows == 1 || s.length()<numRows){
            return s;
        }
        String result = "";
        for (int i = 0; i < s.length(); i += 2 * (numRows - 1)) {
            result += (s.charAt(i));
        }
        for(int i=1;i<numRows-1;i++){
            for(int j=i;j<s.length();j+=2*i){
                result+=s.charAt(j);
                j+=2*(numRows-i-1);
                if(j<s.length())result+=s.charAt(j);
            }
        }
        for (int i = numRows-1; i < s.length(); i += 2 * (numRows - 1)) {
            result += (s.charAt(i));
        }
        return result;
    }

    public static void main(String[] args){
        System.out.println(convert("PAYPALISHIRING", 4));
    }
}
