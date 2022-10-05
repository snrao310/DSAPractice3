import java.util.Arrays;
import java.util.HashMap;

public class TwoSumLeetCode {

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int num = nums[i];
            int rem = target - num;
            if(map.containsKey(rem)){
                return new int[]{i,map.get(rem)};
            }
            map.put(num,i);
        }
        return new int[]{};
    }

    public static void main(String[] args){
        System.out.println(Arrays.toString(twoSum(new int[]{3,3},6)));
    }
}
