import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TopKFrequentElementsLeetCode {

    public static int[] topKFrequent(int[] nums, int k) {
        List<Integer>[] freqList = new ArrayList[nums.length + 1];
        HashMap<Integer, Integer> freqMap = new HashMap<Integer, Integer>();
        for (int i : nums) {
            freqMap.put(i, freqMap.getOrDefault(i, 0) + 1);
        }
        for (int i : freqMap.keySet()) {
            int freq = freqMap.get(i);
            if (freqList[freq] == null)
                freqList[freq] = new ArrayList<Integer>();
            freqList[freq].add(i);
        }
        int count = 0, i = nums.length;
        int[] res = new int[k];
        while (count < k) {
            if (freqList[i] != null) {
                for (int j : freqList[i]) {
                    res[count++] = j;
                    if (count == k)
                        break;
                }
            }
            i--;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 1, 1, 2, 2, 3 };
        int k = 2;
        int[] res = topKFrequent(nums, k);
        for (int i : res)
            System.out.print(i + " ");
    }

}
