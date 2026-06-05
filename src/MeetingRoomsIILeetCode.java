import java.util.Arrays;
import java.util.List;

public class MeetingRoomsIILeetCode {

    public static class Interval {
        public int start, end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static int minMeetingRooms(List<Interval> intervals) {
        int n = intervals.size();
        int[] starts = new int[n];
        int[] ends = new int[n];
        int i = 0, j = 0;
        for (Interval in : intervals) {
            starts[i] = in.start;
            ends[i++] = in.end;
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        int count = 0, res =0;
        for (i = 0, j = 0; i < n && j < n;) {
            if (starts[i] < ends[j]) {
                count++;
                i++;
            } else {
                count--;
                j++;
            }
            res = Math.max(res, count);
        }
        return res;

    }

    public static void main(String[] args) {
        List<Interval> intervals = Arrays.asList(new Interval(0, 30), new Interval(5, 10), new Interval(15, 20));
        System.out.println(minMeetingRooms(intervals));
        intervals = Arrays.asList(new Interval(7, 10), new Interval(2, 4));
        System.out.println(minMeetingRooms(intervals));
        intervals = Arrays.asList(new Interval(1, 5), new Interval(5,10), new Interval(10, 15), new Interval(15, 20), new Interval(1, 20), new Interval(2, 6));
        System.out.println(minMeetingRooms(intervals));
    }

}
