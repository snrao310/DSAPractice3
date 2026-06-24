import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class CourseScheduleLeetCode {

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> neighbors = new HashMap<>();
        for (int[] p : prerequisites) {
            if (!neighbors.containsKey(p[1])) {
                neighbors.put(p[1], new ArrayList<>());
            }
            neighbors.get(p[1]).add(p[0]);
        }
        HashSet<Integer> explored = new HashSet<>();
        for (int i = 0; i < numCourses; i++) {
            if (explored.contains(i))
                continue;
            if (!dfs(i, explored, new HashSet<>(), neighbors))
                return false;
        }
        return true;
    }

    public static boolean dfs(int i, HashSet<Integer> explored, HashSet<Integer> visited,
            HashMap<Integer, List<Integer>> neighbors) {
        if (visited.contains(i))
            return false;
        if (explored.contains(i))
            return true;
        visited.add(i);
        if (neighbors.get(i) != null) {
            for (int n : neighbors.get(i)) {
                if (!dfs(n, explored, visited, neighbors))
                    return false;
            }
        }
        explored.add(i);
        return true;
    }

    public static void main(String[] args) {
        int numCourses = 2;
        int[][] prerequisites = { { 1, 0 },{0,1} };
        boolean result = canFinish(numCourses, prerequisites);
        System.out.println(result); // Output: true
    }

}
