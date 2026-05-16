import java.util.HashMap;
import java.util.HashSet;

public class GraphValidTreeLeetCode {

    public static int visitedNodes=0;

    public static boolean validTree(int n, int[][] edges) {
        if(n==0 || n==1) return edges.length==0;
        visitedNodes=0;
        HashMap<Integer,HashSet<Integer>> neighbors = new HashMap<>();
        for(int[] edge: edges){
            neighbors.putIfAbsent(edge[0], new HashSet<>());
            neighbors.get(edge[0]).add(edge[1]);
            neighbors.putIfAbsent(edge[1],new HashSet<>());
            neighbors.get(edge[1]).add(edge[0]);
        }
        if(neighbors.size()!=n) return false;
        boolean isValidSubTree = dfsIsValidSubTree(0,new boolean[n], neighbors, -1);
        if(isValidSubTree) return visitedNodes==n;
        return false;
    }

    public static boolean dfsIsValidSubTree(int start, boolean[] visited, HashMap<Integer,HashSet<Integer>> neighbors, int parent){
        if(visited[start]) return false;
        visited[start] = true;
        visitedNodes++;
        HashSet<Integer> neighSet = neighbors.get(start);
        for(int neighbor: neighSet){
            if(neighbor==parent) continue;
            if(!dfsIsValidSubTree(neighbor, visited, neighbors,start)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] edges = { };
        System.out.println(validTree(1, edges));
        edges = new int[][] { { 0, 1 }, { 1, 2 }, { 2, 3 }, { 1, 3 }, { 1, 4 } };
        System.out.println(validTree(5, edges));
    }
    
}
