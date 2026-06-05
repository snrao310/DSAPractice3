public class MaximumSubarrayLeetCode {

    public static int maxSubArray(int[] nums) {
        int res =Integer.MIN_VALUE,sum=0;
        for (int i=0;i<nums.length;i++){
            if(sum+nums[i]<nums[i]){
                sum=nums[i];
            }
            else{
                sum+=nums[i];
            }
            res = Math.max(res,sum);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        System.out.println(maxSubArray(nums));
        nums = new int[] { 1 };
        System.out.println(maxSubArray(nums));
        nums = new int[] { 5, 4, -1, 7, 8 };
        System.out.println(maxSubArray(nums));
    }
    
}
