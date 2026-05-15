import java.util.HashSet;

public class ContainsDuplicateLeetCode {

    public static boolean hasDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int i: nums){
            if(set.contains(i)) return true;
            set.add(i);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        System.out.println(hasDuplicate(nums));
    }
    
}
