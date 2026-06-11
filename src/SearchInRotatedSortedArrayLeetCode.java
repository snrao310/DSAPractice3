public class SearchInRotatedSortedArrayLeetCode {

    public static int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        boolean isTargetInSecondHalf = target < nums[0];
        while (l <= r) {
            int m = (l + r) / 2;
            int mval = nums[m];
            if (mval == target)
                return m;
            if (mval < target) {
                if (isTargetInSecondHalf)
                    l = m + 1;
                else if (!isTargetInSecondHalf && mval >= nums[0])
                    l = m + 1;
                else
                    r = m - 1;
            } else {
                if (!isTargetInSecondHalf)
                    r = m - 1;
                else if (isTargetInSecondHalf && mval >= nums[0])
                    l = m + 1;
                else
                    r = m - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = { 4, 5, 6, 7, 0, 1, 2 };
        System.out.println(search(nums, 0));
        System.out.println(search(nums, 3));
    }

}
