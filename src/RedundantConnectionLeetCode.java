import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class RedundantConnectionLeetCode {

    public static boolean pathRecorded = false;

    public static int[] findRedundantConnection(int[][] edges) {
        HashMap<Integer, HashSet<Integer>> graph = new HashMap<>();
        constructGraph(edges, graph);
        HashSet<Integer> explored = new HashSet<>();
        for (int node : graph.keySet()) {
            if (explored.contains(node))
                continue;
            explored.add(node);
            HashSet<Integer> visited = new HashSet<>();
            HashSet<List<Integer>> path = new HashSet<List<Integer>>();
            int cycleStart = cycleNode(node, visited, graph, path, 0);
            if (cycleStart != 0) {
                return findLastEdge(path, edges);
            }
        }
        return new int[2];
    }

    public static int cycleNode(int node, HashSet<Integer> visited, HashMap<Integer, HashSet<Integer>> graph,
            HashSet<List<Integer>> path, int parent) {
        if (visited.contains(node)) {
            pathRecorded = false;
            return node;
        }
        visited.add(node);
        for (int neighbor : graph.get(node)) {
            if (neighbor == parent)
                continue;
            int cycleStart = cycleNode(neighbor, visited, graph, path, node);
            if (cycleStart != 0) {
                if (!pathRecorded) {
                    if (cycleStart == node)
                        pathRecorded = true;
                    List<Integer> edge = new ArrayList<>();
                    edge.add(node);
                    edge.add(neighbor);
                    path.add(edge);
                }
                return cycleStart;
            }
        }
        visited.remove(node);
        return 0;
    }

    public static int[] findLastEdge(HashSet<List<Integer>> path, int[][] edges) {
        for (int i = edges.length - 1; i >= 0; i--) {
            List<Integer> edge1 = List.of(edges[i][0], edges[i][1]);
            List<Integer> edge2 = List.of(edges[i][1], edges[i][0]);
            if (path.contains(edge1) || path.contains(edge2))
                return edges[i];
        }
        return new int[] { 0, 0 };
    }

    public static void constructGraph(int[][] edges, HashMap<Integer, HashSet<Integer>> graph) {
        for (int[] edge : edges) {
            int node1 = edge[0], node2 = edge[1];
            if (!graph.containsKey(node1))
                graph.put(node1, new HashSet<>());
            if (!graph.containsKey(node2))
                graph.put(node2, new HashSet<>());
            graph.get(node1).add(node2);
            graph.get(node2).add(node1);
        }
    }

    public static void main(String[] args) {
        int[][] edges = { { 2, 7 }, { 7, 8 }, { 3, 6 }, { 2, 5 }, { 6, 8 }, { 4, 8 }, { 2, 8 }, { 1, 8 }, { 7, 10 },
                { 3, 9 } };
        int[] res = findRedundantConnection(edges);
        System.out.println(res[0] + " " + res[1]);
    }

}
