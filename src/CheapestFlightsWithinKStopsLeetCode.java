import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class CheapestFlightsWithinKStopsLeetCode {

    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        HashMap<Integer,HashMap<Integer,Integer>> graph = new HashMap<Integer,HashMap<Integer,Integer>>();
        for(int[] fl: flights){
            int source = fl[0], dest = fl[1], cost = fl[2];
            if(!graph.containsKey(source))
                graph.put(source,new HashMap<Integer,Integer>());
            HashMap<Integer, Integer> map = graph.get(source);
            map.put(dest, cost);
        }
        return findCheapBfs(n,graph,src,dst,k);
    }

    public static int findCheapBfs(int n, HashMap<Integer,HashMap<Integer,Integer>> graph, int src, int dst, int k){
        Queue<Integer> queue = new LinkedList<>();
        int[] minCost = new int[n];
        Arrays.fill(minCost, Integer.MAX_VALUE);
        queue.add(src);
        queue.add(null);
        minCost[src] = 0;
        int hops = 0;
        int[] newCosts = Arrays.copyOf(minCost, n);
        while(!queue.isEmpty() && hops<=k){
            if(queue.peek()==null){
                minCost=Arrays.copyOf(newCosts, n);
                queue.poll();
                hops++;
                if(!queue.isEmpty()) queue.add(null);
                continue;
            }
            int polled = queue.poll();
            HashMap<Integer,Integer> flightsOut = graph.get(polled);
            if(flightsOut==null) continue;
            int curCost = minCost[polled];
            for(int node: flightsOut.keySet()){
                newCosts[node] = Math.min(newCosts[node],curCost+flightsOut.get(node));
                if(newCosts[node]<minCost[node])
                    queue.add(node);
            }
        }
        if(minCost[dst]==Integer.MAX_VALUE) return -1;
        return minCost[dst];
    }

    public static void main(String[] args) {
        int n = 5;
        int[][] flights = {{0,1,5},{1,2,5},{0,3,2},{3,1,2},{1,4,1},{4,2,1}};
        int src = 0;
        int dst = 2;
        int k = 2;
        System.out.println(findCheapestPrice(n,flights,src,dst,k));
    }
    
}
