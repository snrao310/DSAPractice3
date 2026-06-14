import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class MergeIntervalsLeetCode {

    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b){
                return Integer.compare(a[0], b[0]);
            }
        });
        List<int[]> resList = new LinkedList<>();
        for(int i=0;i<intervals.length;i++){
            int curStart = intervals[i][0],curEnd = intervals[i][1];
            int j=i+1;
            while(j<intervals.length && intervals[j][0]<=curEnd){
                curEnd = Math.max(curEnd,intervals[j][1]);
                j++;
            }
            i=j-1;
            resList.add(new int[]{curStart,curEnd});
        }
        int[][] res = new int[resList.size()][2];
        int i=0;
        for(int[] inter:resList)
            res[i++]=inter;
        return res;
    }

    public static void main(String[] args){
        int[][] intervals = { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } };
        int[][] res = merge(intervals);
        for(int[] inter:res)
            System.out.println(Arrays.toString(inter));
        System.out.println();
         intervals = new int[][] { { 1, 4 }, { 4, 5 } };
         res = merge(intervals);
        for(int[] inter:res)
            System.out.println(Arrays.toString(inter));
    }
    
}
