import java.util.HashMap;
import java.util.TreeMap;

public class TimeBasedKeyValueStoreLeetCode {

    public static class TimeMap {
        HashMap<String, TreeMap<Integer,String>> map;

        public TimeMap() {
            map = new HashMap<String, TreeMap<Integer,String>>();
        }

        public void set(String key, String value, int timestamp) {
            if(!map.containsKey(key))
                map.put(key,new TreeMap<Integer,String>());
            map.get(key).put(timestamp, value);
        }

        public String get(String key, int timestamp) {
            if(!map.containsKey(key)) return "";
            TreeMap<Integer,String> tmap = map.get(key);
            if(tmap.floorKey(timestamp)==null) return "";
            int floor = tmap.floorKey(timestamp);
            return tmap.get(floor);
        }
    }

    public static void main(String[] args) {
        TimeMap timeMap = new TimeMap();
        timeMap.set("foo", "bar", 1);
        System.out.println(timeMap.get("foo", 1)); // return "bar"
        System.out.println(timeMap.get("foo", 3)); // return "bar" since there is no value corresponding to foo at
                                                   // timestamp 3 and timestamp 2, then the only value is at timestamp 1
                                                   // is "bar"
        timeMap.set("foo", "bar2", 4);
        System.out.println(timeMap.get("foo", 4)); // return "bar2"
        System.out.println(timeMap.get("foo", 5)); // return "bar2"
    }

}
