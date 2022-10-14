import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathInAGridWithObstaclesEliminationLeetCode {

    static int[][] dirns = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public static int shortestPath(int[][] grid, int k) {
        Queue<int[]> queue = new LinkedList<>();
        if (grid[0][0] == 1) return -1;
        int m = grid.length, n = grid[0].length;

        //number of eliminations that were done when this cell was visited last time. In traditional BFS, we don't visit
        //the same cell again, but here we may need to go to the cell again because if this current path gets to the
        //cell with fewer eliminations (more remaining at hand). Initializing this with MAX_VALUE so that it can be used
        //for the first visit as well.
        int[][] visited_with_num_eliminations = new int[m][n];
        for (int[] v : visited_with_num_eliminations) {
            Arrays.fill(v, Integer.MAX_VALUE);
        }

        int steps = 0;
        queue.offer(new int[]{0, 0, 0});
        visited_with_num_eliminations[0][0] = 0;
        queue.offer(null);
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            if (cur != null) {
                if (cur[0] == m - 1 && cur[1] == n - 1) {
                    return steps;
                }
                for (int[] d : dirns) {
                    int new_i = cur[0] + d[0], new_j = cur[1] + d[1];
                    if (new_i == -1 || new_i == grid.length || new_j == -1 || new_j == grid[0].length) continue;
                    if (grid[new_i][new_j] == 1) {
                        if (cur[2] < k) {
                            if (visited_with_num_eliminations[new_i][new_j] > cur[2] + 1) {
                                queue.offer(new int[]{new_i, new_j, cur[2] + 1});
                                visited_with_num_eliminations[new_i][new_j] = cur[2] + 1;
                            }
                        }
                    } else {
                        if (visited_with_num_eliminations[new_i][new_j] > cur[2]) {
                            queue.offer(new int[]{new_i, new_j, cur[2]});
                            visited_with_num_eliminations[new_i][new_j] = cur[2];
                        }
                    }
                }
            } else {
                steps++;
                if (!queue.isEmpty()) {
                    queue.offer(null);
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        //output should be 20
        System.out.println(shortestPath(new int[][]{{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 1, 1, 1, 1, 1, 1, 1, 1, 0}, {0, 1, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 1, 0, 1, 1, 1, 1, 1, 1, 1}, {0, 1, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 1, 1, 1, 1, 1, 1, 1, 1, 0}, {0, 1, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 1, 0, 1, 1, 1, 1, 1, 1, 1}, {0, 1, 0, 1, 1, 1, 1, 0, 0, 0}, {0, 1, 0, 0, 0, 0, 0, 0, 1, 0}, {0, 1, 1, 1, 1, 1, 1, 0, 1, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 1, 0}}, 1));
        //output should be 5
        System.out.println(shortestPath(new int[][]{{0, 0, 1, 0, 0}, {0, 1, 0, 1, 0}}, 2));
    }


}
