import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class ReconstructFlightPathLeetCode {

    public static List<String> findItinerary(List<List<String>> tickets) {
        HashMap<String, PriorityQueue<String>> graph = constructGraph(tickets), graph2 = constructGraph(tickets);
        HashMap<String, String> lastEdge = new HashMap<>();
        List<String> res = new ArrayList<>();
        res.add("JFK");
        findlastEdge("JFK", graph2, lastEdge);
        dfs("JFK", res, graph, lastEdge);
        return res;
    }

    public static HashMap<String, PriorityQueue<String>> constructGraph(List<List<String>> tickets) {
        HashMap<String, PriorityQueue<String>> graph = new HashMap<>();
        for (List<String> edge : tickets) {
            String source = edge.get(0);
            String dest = edge.get(1);
            if (!graph.containsKey(source)) {
                graph.put(source, new PriorityQueue<>());
            }
            graph.get(source).add(dest);
        }
        return graph;
    }

    public static void findlastEdge(String source, HashMap<String, PriorityQueue<String>> graph,
            HashMap<String, String> lastEdge) {
        PriorityQueue<String> edges = graph.get(source);
        if (edges == null)
            return;
        while (!edges.isEmpty()) {
            String edge = edges.poll();
            findlastEdge(edge, graph, lastEdge);
            if (!edges.isEmpty())
                lastEdge.put(source, edge);

        }
    }

    public static void dfs(String source, List<String> res, HashMap<String, PriorityQueue<String>> graph,
            HashMap<String, String> lastEdge) {
        PriorityQueue<String> edges = graph.get(source);
        if (edges == null)
            return;
        while (!edges.isEmpty()) {
            String edge = edges.poll();
            if (lastEdge.get(source) == edge)
                continue;
            res.add(edge);
            dfs(edge, res, graph, lastEdge);
        }
        String edge = lastEdge.get(source);
        if(edge!=null){
            res.add(edge);
            lastEdge.remove(source);
        }
        dfs(edge, res, graph, lastEdge);
    }

    public static void main(String[] args) {
        // Example usage
        List<List<String>> tickets = List.of(
                List.of("JFK", "KUL"),
                List.of("JFK", "NRT"),
                List.of("NRT", "JFK"));
        List<String> itinerary = findItinerary(tickets);
        System.out.println(itinerary); // Output: [JFK, BUF, HOU, SEA]
    }
}
