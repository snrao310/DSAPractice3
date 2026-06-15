import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MeetingRoomsLeetCode {

    public static class Interval {
        int start, end;
        public Interval(int start,int end){
            this.start = start;
            this.end = end;
        }
    }

    public static boolean canAttendMeetings(List<Interval> intervals) {
        List<Interval> list = new ArrayList<>(intervals);
        list.sort(new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start-o2.start;
            }
        });
        if(list.size()==0) return true;
        Interval cur = list.get(0);
        for(int i=1;i<list.size();i++){
            Interval next = list.get(i);
            if(cur.end>next.start) return false;
            cur = next;
        }
        return true;
    }

    public static void main(String[] args) {
        List<Interval> intervals = List.of(new Interval(5, 10), new Interval(0, 3), new Interval(3, 6));
        boolean res = canAttendMeetings(intervals);
        System.out.println(res);
    }

}
