public class KthLargestElementInAnArrayLeetCode {

    public static int findKthLargest(int[] nums, int k) {
        return findKth(nums, 0,nums.length-1,k);
    }

    public static int findKth(int[] nums, int start, int end, int k){
        if(start==end) return nums[start];
        int sel = start;
        for(int i=start+1;i<=end;i++){
            if(nums[i]<nums[sel]){
                int temp = nums[sel];
                nums[sel] = nums[i];
                nums[i] = nums[sel+1];
                nums[sel+1] = temp;
            }
        }
        int largestPos = nums.length - sel;
        if(largestPos ==k) return nums[sel];
        else if(largestPos<k) return findKth(nums,start,sel-1,k);
        else return findKth(nums,sel+1,end,k);
    }

    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,4};
        int k = 2;
        System.out.println(findKthLargest(nums,k));
    }
    
}
