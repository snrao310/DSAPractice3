import java.util.HashMap;

public class LongestConsecutiveSequenceLeetCode {

    public static int longestConsecutive(int[] nums) {
        HashMap<Integer, Boolean> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, false);
        }
        int max = 0;
        for (int n : nums) {
            if (!map.get(n)) {
                int len = 0, cur = n;
                while (map.containsKey(cur)) {
                    len++;
                    cur--;
                }
                cur = n + 1;
                while (map.containsKey(cur)) {
                    len++;
                    cur++;
                }
                max = Math.max(len, max);
                map.put(n, true);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int res = longestConsecutive(new int[] { 2, 20, 4, 10, 3, 4, 5 });
        System.out.println(res);
    }
}
