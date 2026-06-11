public class FindTheDuplicateNumberLeetCode {

    public static int findDuplicate(int[] nums) {
        for(int i=0;i<nums.length;i++){
            int val = Math.abs(nums[i]);
            if(nums[val-1]<0) return val;
            nums[val-1]*=-1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 3, 4, 2, 2 };
        System.out.println(findDuplicate(nums));
        nums = new int[] { 3, 1, 3, 4, 2 };
        System.out.println(findDuplicate(nums));
    }
    
}
