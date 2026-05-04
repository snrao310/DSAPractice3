import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class LastStoneWeightLeetCode {

    public static int lastStoneWeight(int[] stones) {
        List<Integer> list = new ArrayList<>();
        for(int i: stones) list.add(i);
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        maxHeap.addAll(list);
        while(!maxHeap.isEmpty()){
            int max = maxHeap.poll();
            if(maxHeap.isEmpty()) return max;
            int secondMax = maxHeap.poll();
            if(max!=secondMax)
                maxHeap.add(max-secondMax);
        }
        return 0;
    }
    

    public static void main(String[] args) {
        int[] stones = {2,7,4,1,8,1};
        System.out.println(lastStoneWeight(stones));
    }
}
