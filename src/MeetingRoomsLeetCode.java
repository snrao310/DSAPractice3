import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MeetingRoomsLeetCode {

    static class Interval{
        int start, end;
        Interval(int start, int end){
            this.start = start;
            this.end = end;
        }
    }

    public static boolean canAttendMeetings(List<Interval> intervals) {
        Interval[] intervalArray = new Interval[intervals.size()];
        intervals.toArray(intervalArray);
        Arrays.sort(intervalArray, new Comparator<Interval>(){
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });
        int prevEnd = 0;
        for(int i =0;i<intervalArray.length;i++){
            int curStart = intervalArray[i].start;
            if(curStart<prevEnd) return false;
            prevEnd = intervalArray[i].end;
        }
        return true;
    }

    public static void main(String args[]){
        List<Interval> input = new ArrayList<>();
        input.add(new Interval(5,10)); input.add(new Interval(0,30)); input.add(new Interval(15,20));
        System.out.println(canAttendMeetings(input));

        List<Interval> input2 = new ArrayList<>();
        input2.add(new Interval(5,10)); input2.add(new Interval(0,4)); input2.add(new Interval(15,20));
        System.out.println(canAttendMeetings(input2));
    }
}
