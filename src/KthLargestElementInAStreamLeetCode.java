import java.util.Arrays;
import java.util.PriorityQueue;

public class KthLargestElementInAStreamLeetCode {

    static class KthLargest {

        PriorityQueue<Integer> heap;
        int k;

        public KthLargest(int k, int[] nums) {
            Arrays.sort(nums);
            this.k = k;
            heap = new PriorityQueue<Integer>();
            int kcount = 0;
            for (int i = nums.length-1; i>=0 && kcount<k; i--) {
                heap.add(nums[i]);
                kcount++;
            }
        }

        public int add(int val) {
            if(heap.size()<k) heap.add(val);
            else if (val > heap.peek()) {
                heap.poll();
                heap.add(val);
            }
            return heap.peek();
        }
    }

    public static void main(String[] args) {
        int k = 3;
        int[] nums = { 1000,-1000 };
        KthLargest kthLargest = new KthLargest(k, nums);
        System.out.println(kthLargest.add(0)); // returns 4
        System.out.println(kthLargest.add(5)); // returns 5
        System.out.println(kthLargest.add(10)); // returns 5
        System.out.println(kthLargest.add(9)); // returns 8
        System.out.println(kthLargest.add(4)); // returns 8
    }

}
