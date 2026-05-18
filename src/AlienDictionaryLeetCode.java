import java.util.HashMap;
import java.util.HashSet;

public class AlienDictionaryLeetCode {

    public static String foreignDictionary(String[] words) {
        if(words.length==0) return "";
        if(words.length==1) return words[0];
        HashMap<Character, HashSet<Character>> nodeMap = createGraph(words);
        return topSort(nodeMap);
    }

    public static  HashMap<Character, HashSet<Character>> createGraph(String[] words) {
         HashMap<Character, HashSet<Character>> nodeMap = new HashMap<>();
        for (int i = 0; i < words.length - 1; i++) {
            char[] word1 = words[i].toCharArray();
            char[] word2 = words[i + 1].toCharArray();
            int j = 0;
            while (j < word1.length && j < word2.length && word1[j] == word2[j]) {
                nodeMap.putIfAbsent(word1[j],new HashSet<Character>());
                j++;
            }
            int k=j;
            while(k<word1.length){
                nodeMap.putIfAbsent(word1[k++],new HashSet<Character>());
            }
            k=j;
            while(k<word2.length){
                nodeMap.putIfAbsent(word2[k++],new HashSet<Character>());
            }
            if(j==word2.length && j!=word1.length) return new HashMap<>();
            if (j == word1.length)
                continue;
            HashSet<Character> node1Next = nodeMap.get(word1[j]);
            node1Next.add(word2[j]);
        }
        return nodeMap;
    }

    public static String topSort(HashMap<Character,HashSet<Character>> nodeMap){
        StringBuilder res = new StringBuilder();
        HashSet<Character> visited = new HashSet<>();
        for(char c: nodeMap.keySet()){
            if(visited.contains(c)) continue;
            String sub = dfs(c,nodeMap,visited, new HashSet<Character>(),"");
            if(sub.equals("0")) return "";
            res.insert(0, sub);
        }
        return res.toString();
    }

    public static String dfs(Character c, HashMap<Character,HashSet<Character>> nodeMap, HashSet<Character> visited, HashSet<Character> cycleDet, String subString){
        if(cycleDet.contains(c)) return "0";
        if(visited.contains(c)) return "";
        cycleDet.add(c);
        visited.add(c);
        for(Character next: nodeMap.get(c)){
            subString = dfs(next, nodeMap,visited,cycleDet,subString);
            if(subString.equals("0")) return "0";
        }
        subString=c+subString;
        return subString;
    }

    public static void main(String[] args) {
        String[] words = { "hrn", "hrf", "er", "enn", "rfnn" };
        System.out.println(foreignDictionary(words));
        words = new String[] { "z", "o" };
        System.out.println(foreignDictionary(words));
        words = new String[] {"abc","bcd","cde" };
        System.out.println(foreignDictionary(words));
        words = new String[] {"wrtkj","wrt" };
        System.out.println(foreignDictionary(words));
        words = new String[] {"z","z" };
        System.out.println(foreignDictionary(words));
        words = new String[] {"abcdefgh","bdefghij","cghij","dfghij","efghij","fghij","ghij","hij","ij","j","abcdefghi","bdefghijk","cghijk","dfghijk","efghijk","fghijk","ghijk","hijk","ijk","jk","k" };
        System.out.println(foreignDictionary(words));
    }

}
