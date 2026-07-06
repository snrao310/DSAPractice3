import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

public class NetworkDelayTimeLeetCode {
    public static int networkDelayTime(int[][] times, int n, int k) {
        HashMap<Integer, HashMap<Integer, Integer>> graph = new HashMap<>();
        for (int[] edge : times) {
            int source = edge[0];
            int dest = edge[1];
            int time = edge[2];
            if (!graph.containsKey(source))
                graph.put(source, new HashMap<Integer, Integer>());
            graph.get(source).put(dest, time);
        }
        int[] timesFromSource = new int[n + 1];
        Arrays.fill(timesFromSource, Integer.MAX_VALUE);
        boolean[] visited = new boolean[n + 1];
        bfsDijskstra(graph, k, timesFromSource, visited);
        int res = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            if (!visited[i])
                return -1;
            res = Math.max(res, timesFromSource[i]);
        }
        return res;
    }

    public static void bfsDijskstra(HashMap<Integer, HashMap<Integer, Integer>> graph, int k, int[] timesFromSource,
            boolean[] visited) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((a,b)-> timesFromSource[a] - timesFromSource[b]);
        queue.add(k);
        timesFromSource[k] = 0;
        visited[k] = true;
        while (!queue.isEmpty()) {
            int source = queue.poll();
            HashMap<Integer, Integer> neighbors = graph.get(source);
            if (neighbors == null)
                continue;
            for (int node : neighbors.keySet()) {
                int time = neighbors.get(node);
                if (timesFromSource[source] + time < timesFromSource[node])
                    timesFromSource[node] = timesFromSource[source] + time;
                if (!visited[node]) {
                    visited[node] = true;
                    queue.add(node);
                }
            }
        }
    }
    
    public static void main(String[] args) {
        int[][] times = { { 2, 1, 1 }, { 2, 3, 1 }, { 3, 4, 1 } };
        int n = 4;
        int k = 2;
        System.out.println(networkDelayTime(times, n, k));
    }
}
