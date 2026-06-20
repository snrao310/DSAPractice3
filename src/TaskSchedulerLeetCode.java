import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class TaskSchedulerLeetCode {

    static class HeapNode {
        int pos;
        int fre;

        HeapNode(int fre, int pos) {
            this.fre = fre;
            this.pos = pos;
        }
    }

    public static int leastInterval(char[] tasks, int n) {
        PriorityQueue<HeapNode> heap = new PriorityQueue<>(new Comparator<HeapNode>() {
            @Override
            public int compare(HeapNode n1, HeapNode n2) {
                return Integer.compare(n2.fre, n1.fre);
            }
        });
        HashMap<Character, Integer> freqMap = new HashMap<>();
        for (char c : tasks) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }
        for (int v : freqMap.values()) {
            heap.add(new HeapNode(v, 0));
        }
        Queue<HeapNode> queue = new LinkedList<>();
        int res = 0;
        while (!queue.isEmpty() || !heap.isEmpty()) {
            while(!queue.isEmpty() && queue.peek().pos<=res){
                heap.add(queue.poll());
            }
            HeapNode cur = heap.peek();
            if (cur != null && cur.pos <= res) {
                cur = heap.poll();
                if (cur.fre > 1) {
                    queue.offer(new HeapNode(cur.fre - 1, res + 1+n));
                }
            }
            res++;
        }
        return res;
    }

    public static void main(String[] args) {
        char[] tasks = { 'A','A','A','A','A','A','B','C','D','E','F','G' };
        int n = 1;
        System.out.println(leastInterval(tasks, n));
    }

}
