import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;

public class MInCostToConnectPointsLeetCode {

    public static int minCostConnectPoints(int[][] points) {
        HashSet<List<Integer>> visited = new HashSet<>();
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> a[2]-b[2]);
        minHeap.add(new int[]{points[0][0],points[0][1],0});
        int minCost = 0;
        while(visited.size()!=points.length){
            int[] nextPoint = minHeap.poll();
            int x=nextPoint[0], y=nextPoint[1], cost = nextPoint[2];
            if(visited.contains(List.of(x,y))) continue;
            visited.add(List.of(x,y));
            minCost += cost;
            for(int[] point:points){
                if(visited.contains(List.of(point[0],point[1]))) continue;
                int dist = Math.abs(x-point[0]) + Math.abs(y-point[1]);
                minHeap.add(new int[]{point[0],point[1],dist});
            }
        }
        return minCost;
    }
    
    public static void main(String[] args) {
        int[][] points = {{0,0},{2,2},{3,10},{5,2},{7,0}};
        System.out.println(minCostConnectPoints(points));
    }
    
}
