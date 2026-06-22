import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Arrays;

public class GroupAnagramsLeetCode {

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] st = s.toCharArray();
            int[] freq = new int[26];
            for (char c : st) {
                freq[c - 'a']++;
            }
            String countString = Arrays.toString(freq);
            if (!map.containsKey(countString))
                map.put(countString, new ArrayList<String>());
            map.get(countString).add(s);
        }
        List<List<String>> res = new ArrayList<>();
        for (List<String> list : map.values()) res.add(list);
        return res;
    }

    public static void main(String[] args) {
        GroupAnagramsLeetCode solution = new GroupAnagramsLeetCode();
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result = solution.groupAnagrams(strs);
        System.out.println(result);
    }
    
}
