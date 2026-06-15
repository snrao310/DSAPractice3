import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class WordLadderLeetCode {

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> words = new HashSet<>();
        for(String w: wordList) words.add(w);
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        if(words.contains(beginWord)) words.remove(beginWord);
        queue.offer(null);
        int res = 1;
        while(!queue.isEmpty()){
            String el = queue.poll();
            if(el == null){
                if(!queue.isEmpty()) queue.offer(null);
                res++;
                continue;
            }
            if(el.equals(endWord))
                return res;
            for(int i=0;i<el.length();i++){
                for(int j=0;j<26;j++){
                    char[] elChar = el.toCharArray();
                    char newChar = (char) ('a'+j);
                    if(elChar[i]==newChar) continue;
                    elChar[i]=newChar;
                    String newString = String.valueOf(elChar);
                    if(words.contains(newString)){
                        queue.offer(newString);
                        words.remove(newString);
                    }
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = List.of("hot","dot","dog","lot","log","cog");
        int res = ladderLength(beginWord, endWord, wordList);
        System.out.println(res);
    }
    
}
