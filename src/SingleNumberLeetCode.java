public class SingleNumberLeetCode {

    public static int singleNumber(int[] nums) {
        int res=0;
        for(int num: nums){
            res=res ^ num;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {2,2,1};
        System.out.println(singleNumber(nums));
        nums = new int[]{4,1,2,1,2};
        System.out.println(singleNumber(nums));
        nums = new int[]{1};
        System.out.println(singleNumber(nums));
    }
    
}
