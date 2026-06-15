import java.util.ArrayList;
import java.util.List;

public class InsertIntervalLeetCode {

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        int newStart = newInterval[0], newEnd = newInterval[1], n = intervals.length;
        if(n==0) return new int[][]{newInterval};
        boolean added = false;
        for (int i = 0; i < n; i++) {
            int[] curInt = intervals[i];
            if (curInt[0] < newStart && curInt[1] < newStart)
                res.add(curInt);
            else if (curInt[0] > newEnd) {
                if (!added) {
                    res.add(newInterval);
                    added = true;
                }
                res.add(curInt);
            }
            else{
                int mergeStart = Math.min(curInt[0], newStart);
                int mergeEnd = Math.max(curInt[1], newEnd);
                int j=i+1;
                while(j<n && intervals[j][0]<=mergeEnd){
                    mergeEnd=Math.max(mergeEnd, intervals[j][1]);
                    j++;
                }
                res.add(new int[]{mergeStart, mergeEnd});
                i=j-1;
                added = true;
            }
        }
        if(!added) res.add(newInterval);
        int[][] resArray = new int[res.size()][2];
        int i=0;
        for(int[] in:res){
            resArray[i++]=in;
        }
        return resArray;
    }

    public static void main(String[] args) {
        int[][] intervals = { { 1, 3 }, { 6, 9 } };
        int[] newInterval = { 2, 5 };
        int[][] res = insert(intervals, newInterval);
        for (int[] i : res) {
            System.out.println(i[0] + " " + i[1]);
        }
    }

}
