import java.util.HashSet;
import java.util.List;

public class WordBreakLeetCode {

    public static boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> words = new HashSet<>();
        for(String w: wordDict)
            words.add(w);
        return backtrack(s,words,new int[s.length()],0);
    }

    public static boolean backtrack(String s, HashSet<String> words, int[] dp, int ind){
        if(ind==s.length()) return true;
        if(dp[ind]!=0) return dp[ind]==1;
        for(int i=ind;i<s.length();i++){
            if(words.contains(s.substring(ind,i+1))){
                if(backtrack(s, words, dp, i+1)){
                    dp[ind]=1;
                    return true;
                }
            }
        }
        dp[ind]=-1;
        return false;
    }

    public static void main(String[] args) {
        String s = "leetcode";
        List<String> wordDict = List.of("leet", "code");
        System.out.println(wordBreak(s, wordDict));
    }
    
}
