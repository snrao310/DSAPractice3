import java.util.Arrays;
import java.util.HashSet;

public class HandOfStraightsLeetCode {

    public static boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0)
            return false;
        Arrays.sort(hand);
        HashSet<Integer> set = new HashSet();
        int count = 0, prev = 0;
        while (set.size() != hand.length) {
            int i = 0;
            while (i < hand.length && set.contains(i)) {
                i++;
            }
            if (i == hand.length)
                return false;
            count = 1;
            prev = hand[i];
            set.add(i);
            for (; i < hand.length && count < groupSize; i++) {
                if (set.contains(i))
                    continue;
                if (hand[i] == prev + 1) {
                    count++;
                    set.add(i);
                    prev = hand[i];
                }
            }
            if (count != groupSize)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] hand = { 1, 2, 4, 2, 3, 5, 3, 4 };
        int groupSize = 4;
        boolean result = isNStraightHand(hand, groupSize);
        System.out.println(result); // Output: true
    }

}
