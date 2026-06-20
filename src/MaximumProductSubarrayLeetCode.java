import java.util.Arrays;

public class MaximumProductSubarrayLeetCode {

    public static int maxProduct(int[] nums) {
        int max=nums[0], min=nums[0], res =nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i]==0){
                max=min=1;
            }
            int minPrev = min, maxPrev = max;
            min = Math.min(nums[i], Math.min(nums[i]*minPrev, nums[i]*maxPrev));
            max = Math.max(nums[i], Math.max(nums[i]*minPrev, nums[i]*maxPrev));
            res = Math.max(max, res);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = { -3,-1,-1 };
        System.out.println(maxProduct(nums));
    }
    
}
