public class MissingNumberLeetCode {

    public static int missingNumber(int[] nums) {
        int sum = 0, expected_sum = nums.length;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            expected_sum+=i;
        }
        return expected_sum-sum;
    }

    public static void main(String[] args) {
        System.out.println(missingNumber(new int[]{9,6,4,2,3,5,7,0,1}));
    }
}
