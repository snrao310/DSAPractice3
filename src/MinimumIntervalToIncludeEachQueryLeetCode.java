import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MinimumIntervalToIncludeEachQueryLeetCode {

    public static int[] minInterval(int[][] intervals, int[] queries) {
        int[] res = new int[queries.length];
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] i1, int[] i2){
                return Integer.compare(i1[0], i2[0]);
            }
        });
        class QueryElem{
            int query;
            int index;
            QueryElem(int q, int i){
                query = q;
                index = i;
            }
        }
        QueryElem[] queryElems = new QueryElem[queries.length];
        for(int i=0;i<queries.length;i++){
            queryElems[i]=new QueryElem(queries[i],i);
        }
        Arrays.sort(queryElems, new Comparator<QueryElem>(){
            @Override
            public int compare(QueryElem q1, QueryElem q2){
                return Integer.compare(q1.query, q2.query);
            }
        });
        class HeapElem{
            int intervalLength;
            int intervalRight;
            HeapElem(int ilen, int ir){
                intervalLength=ilen;
                intervalRight = ir;
            }
        }
        PriorityQueue<HeapElem> minHeap = new PriorityQueue<>(new Comparator<HeapElem>() {
            @Override
            public int compare(HeapElem h1, HeapElem h2){
                return Integer.compare(h1.intervalLength, h2.intervalLength);
            }
        });
        int j=0;
        for(int i=0;i<queryElems.length;i++){
            QueryElem queryElem = queryElems[i];
            int queryVal = queryElem.query;
            while(j<intervals.length && intervals[j][0] <=queryVal){
                int len = intervals[j][1]-intervals[j][0]+1;
                minHeap.add(new HeapElem(len,intervals[j][1]));
                j++;
            }
            HeapElem minElem = null;
            while(!minHeap.isEmpty() && minHeap.peek().intervalRight<queryVal){
                minHeap.poll();
            }
            if(!minHeap.isEmpty()) minElem = minHeap.peek();
            res[queryElem.index]=minElem==null?-1:minElem.intervalLength;
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] intervals = { { 1, 3 }, { 2, 3 }, { 3, 7 }, { 6, 6 } };
        int[] queries = { 2, 3, 1, 7, 6, 8 };
        int[] result = minInterval(intervals, queries);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }

}
