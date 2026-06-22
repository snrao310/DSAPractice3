import java.util.Comparator;
import java.util.PriorityQueue;

public class KClosestPointsToOriginLeetCode {

    public static int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> heap = new PriorityQueue<int[]>(new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b){
                int dista = a[0]*a[0] + a[1]*a[1];
                int distb = b[0]*b[0] + b[1]*b[1];
                return Integer.compare(distb, dista);
            }
        });
        for(int[] point: points){
            heap.add(point);
            if(heap.size()>k){
                heap.poll();
            }
        }
        int[][] res = new int[k][2];
        int i=0;
        for(int[] point: heap){
            res[i++] = point;
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] points = {{1, 3}, {-2, 2}};
        int k = 1;
        int[][] result = kClosest(points, k);
        for (int[] point : result) {
            System.out.println("[" + point[0] + ", " + point[1] + "]");
        }
    }
    
}
