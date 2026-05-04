import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ThreeSumLeetCode {

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new LinkedList<>();
        for(int i=0;i<nums.length-1;i++){
            int val = nums[i], target = 0-nums[i];
            if(i>0 && val== nums[i-1]) continue;
            int j=i+1, k=nums.length-1;
            while(j<k){
                int sum = nums[j] +nums[k];
                int jval=nums[j], kval=nums[k];
                if(sum==target){
                    res.add(new LinkedList<>(List.of(val,nums[j],nums[k])));
                    while(jval==nums[j] && kval==nums[k] && j<k){
                        j++;k--;
                    }
                }
                else if(sum>target) k--;
                else j++;
            }
        }
        return res;
    }


    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        System.out.println(threeSum(nums));
        nums = new int[]{0,0,0,0};
        System.out.println(threeSum(nums));
    }
    
}
