import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PartitionLabelsLeetCode {

    public static List<Integer> partitionLabels(String s) {
        HashMap<Character,Integer> lastIndMap = new HashMap<>();
        for(int i=0;i<s.length();i++){
            lastIndMap.put(s.charAt(i),i);
        }
        List<Integer> res = new ArrayList<>();
        int l=0,r=0;
        while(r<s.length()){
            int i=l;
            while(i<=r){
                char c=s.charAt(i);
                int lastInd = lastIndMap.get(c);
                r=Math.max(r,lastInd);
                i++;
            }
            res.add(r-l+1);
            l=r+1; r=r+1;
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "xyxxyzbzbbisl";
        System.out.println(partitionLabels(s));
    }
    
}
