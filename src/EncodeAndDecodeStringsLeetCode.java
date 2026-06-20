import java.util.ArrayList;
import java.util.List;

public class EncodeAndDecodeStringsLeetCode {


    public static String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String s: strs){
            sb.append(s.length()+"#"+s);
        }
        return sb.toString();
    }

    public static List<String> decode(String str) {
        List<String> res = new ArrayList();
        for(int i=0;i<str.length();i++){
            StringBuilder sb = new StringBuilder();
            int start = i;
            while(str.charAt(i)!='#')
                i++;
            int len = Integer.valueOf(str.substring(start,i));
            res.add(str.substring(i+1,i+1+len));
            i+=len;
        }
        return res;
    }

    public static void main(String[] args) {
        List<String> strs = new ArrayList<>();
        strs.add("Hello");
        strs.add("World");
        String encoded = encode(strs);
        System.out.println("Encoded: " + encoded);
        List<String> decoded = decode(encoded);
        System.out.println("Decoded: " + decoded);
    }
    
}
