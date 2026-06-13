import java.util.Arrays;
import java.util.Comparator;

public class NonOverlappingIntervalsLeetCode {

    public static int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] int1, int[] int2) {
                return Integer.compare(int1[0], int2[0]);
            }
        });
        int remove=0;
        for(int i=0;i<intervals.length;i++){
            int curEnd = intervals[i][1];
            int j=i+1;
            while(j<intervals.length && intervals[j][0]<curEnd){
                int overlapEnd = intervals[j][1];
                if(overlapEnd<curEnd)
                    curEnd=overlapEnd;
                remove++;
                j++;
            }
            i=j-1;
        }
        return remove;
    }

    public static void main(String[] args) {
        int[][] intervals = { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 1, 3 } };
        System.out.println(eraseOverlapIntervals(intervals));
        intervals = new int[][] { { 1, 2 }, { 1, 2 }, { 1, 2 } };
        System.out.println(eraseOverlapIntervals(intervals));
        intervals = new int[][] { { 1, 2 }, { 2, 3 } };
        System.out.println(eraseOverlapIntervals(intervals));
    }
    
}
