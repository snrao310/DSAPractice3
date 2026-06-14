public class TwoIntegerSumIILeetCode {

    public static int[] twoSum(int[] numbers, int target) {
        int l=0, r=numbers.length-1;
        while(l<r){
            int diff = target - numbers[l], curRight = numbers[r];
            if(diff==curRight) return new int[]{l+1,r+1};
            if(diff>curRight) l++;
            else r--;
        }
        return new int[]{-1,-1};
    }

    public static void main(String[] args) {
        int[] nums = { 2, 7, 11, 15 };
        int target = 9;
        int[] res = twoSum(nums, target);
        System.out.println(res[0] + " " + res[1]);
    }
    
}
