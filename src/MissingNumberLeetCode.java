import java.util.HashSet;

public class MissingNumberLeetCode {

    public static int missingNumber(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }
        for(int i=0;i<nums.length;i++){
            if(!set.contains(i)){
                return i;
            }
        }
        return nums.length;
    }

    public static void main(String[] args){
        int[] input = {1,2,3};
        System.out.println(missingNumber(input));
        int[] input2 = {0,2};
        System.out.println(missingNumber(input2));
    }
    
}
