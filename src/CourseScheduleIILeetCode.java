import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class CourseScheduleIILeetCode {

    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < numCourses; i++)
            graph.put(i, new ArrayList<Integer>());
        for (int[] pre : prerequisites) {
            int course = pre[0];
            int prereq = pre[1];
            graph.get(prereq).add(course);
        }
        boolean[] explored = new boolean[numCourses];
        int[] res = new int[numCourses];
        int ind = numCourses - 1;
        for (int i = 0; i < numCourses; i++) {
            if (!explored[i]){
                ind = dfs(i, graph, explored, res, ind, new HashSet<Integer>());
                if(ind==numCourses) return new int[0];
            }
        }
        return res;
    }

    public static int dfs(int i, HashMap<Integer, List<Integer>> graph, boolean[] explored, int[] res, int ind,
            HashSet<Integer> visited) {
        if (visited.contains(i))
            return res.length; //cycle - using impossible index
        if (explored[i])
            return ind;
        visited.add(i);
        explored[i] = true;
        for (int next : graph.get(i)) {
            ind = dfs(next, graph, explored, res, ind, visited);
            if(ind==res.length) return ind; //cycle
        }
        res[ind] = i;
        ind--;
        visited.remove(i);
        return ind;
    }

    public static void main(String[] args) {
        int numCourses = 8;
        int[][] prerequisites = { { 2, 1 }, { 2, 5 }, { 3, 7 }, { 3, 2 }, { 3, 6 }, { 4, 3 } };
        int[] order = findOrder(numCourses, prerequisites);
        for (int course : order) {
            System.out.print(course + " ");
        }
    }

}
