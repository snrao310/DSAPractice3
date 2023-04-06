import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ThreeSumLeetCode {

    public static List<List<Integer>> threeSum(int[] nums) {
        int len = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> res = new LinkedList<>();
        for(int i=0;i<len-2;i++){
            int num = nums[i], target = 0-nums[i];
            if(i>0 && nums[i] ==nums[i-1]){
                continue;
            }
            int low = i+1, high = len-1;
            while(low<high){
                int lowVal = nums[low], highVal = nums[high];
                int sum = lowVal+highVal;
                if(sum<target){
                    low++;
                } else if (sum>target) {
                    high--;
                }else{
                    res.add(Arrays.asList(num,nums[low],nums[high]));
                    while(low<len && nums[low]==lowVal)low++;
                    while(high>=0 && nums[high]==highVal)high--;
                }
            }
        }
        return res;
    }

    public static void main(String[] args){
        int[] arr = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> k = threeSum(arr);
        for (List<Integer> l : k) {
            for (Integer m : l)
                System.out.print(m + " ");
            System.out.println();
        }
    }
}
