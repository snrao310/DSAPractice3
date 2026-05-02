public class FindMinimumInRotatedSortedArrayLeetCode {

    public static int findMin(int[] nums) {
        int l=0, r=nums.length-1;
        while(l<r){
            int m=(l+r)/2;
            int rval=nums[r], mval=nums[m];
            if(mval>rval){
                l=m+1;
            }
            else{
                r=m;
            }
        }
        return nums[r];
    }

    public static void main(String[] args){
        int[] nums = {3,4,5,6,1,2};
        System.out.println(findMin(nums));
        nums = new int[]{4,5,0,1,2,3};
        System.out.println(findMin(nums));
        nums = new int[]{4,5,6,7};
        System.out.println(findMin(nums));
    }
    
}
