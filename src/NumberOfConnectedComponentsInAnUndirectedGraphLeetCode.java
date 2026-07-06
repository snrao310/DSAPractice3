import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class NumberOfConnectedComponentsInAnUndirectedGraphLeetCode {

    public static int countComponents(int n, int[][] edges) {
        HashMap<Integer,List<Integer>> graph = new HashMap<>();
        for(int[] edge: edges){
            if(!graph.containsKey(edge[0]))
                graph.put(edge[0], new ArrayList<>());
            if(!graph.containsKey(edge[1]))
                graph.put(edge[1], new ArrayList<>());
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        boolean[] visited = new boolean[n];
        int res=0;
        for(int i=0;i<n;i++){
            if(!visited[i]){
                res++;
                dfs(graph,i,visited);
            }
        }
        return res;
    }

    public static void dfs(HashMap<Integer,List<Integer>> graph, int i, boolean[] visited){
        if(visited[i]) return;
        visited[i]=true;
        List<Integer> neighbors = graph.get(i);
        if(neighbors==null) return;
        for(int node: neighbors){
            dfs(graph,node,visited);
        }
    }

    public static void main(String[] args) {
        int n = 2;
        int[][] edges = { { 1,0 } };
        System.out.println(countComponents(n, edges));
    }
    
}
