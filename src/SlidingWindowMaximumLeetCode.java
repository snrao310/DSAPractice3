import java.util.PriorityQueue;

public class SlidingWindowMaximumLeetCode {

    public static int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>((a,b)->b-a);
        for(int i=0;i<k;i++) heap.add(nums[i]);
        int[] res = new int[nums.length-k+1];
        res[0]=heap.peek();
        for(int i=1;i<res.length;i++){
            heap.remove(nums[i-1]);
            heap.add(nums[i+k-1]);
            res[i]=heap.peek();
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 3, -1, -3, 5, 3, 6, 7 };
        int k = 3;
        int[] result = maxSlidingWindow(nums, k);
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
    
}
