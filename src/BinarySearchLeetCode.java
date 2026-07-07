public class BinarySearchLeetCode {

    public static int search(int[] nums, int target) {
        int l=0, r=nums.length-1;
        while(l<=r){
            int m=(l+r)/2;
            if(target==nums[m]) return m;
            if(target<nums[m]) r=m-1;
            else l=m+1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {-1,0,3,5,9,12};
        int target = 9;
        int result = search(nums, target);
        System.out.println(result); // Output: 4
    }
    
}
