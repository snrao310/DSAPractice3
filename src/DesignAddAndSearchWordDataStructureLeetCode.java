import java.util.HashMap;
import java.util.HashSet;

public class DesignAddAndSearchWordDataStructureLeetCode {

    public static class WordDictionary {
        class TrieNode{
            HashMap<Character, TrieNode> children;
            boolean isEnd;

            TrieNode(){
                this.isEnd=false;
                this.children = new HashMap<>();
            }
        }
        TrieNode root;
        public WordDictionary() {
            this.root = new TrieNode();
        }

        public void addWord(String word) {
            char[] wordArr = word.toCharArray();
            TrieNode cur = root;
            for(char c: wordArr){
                HashMap<Character,TrieNode> children = cur.children;
                if(!children.containsKey(c)){
                    children.put(c, new TrieNode());
                }
                cur = cur.children.get(c);
            }
            cur.isEnd = true;
        }
        
        public boolean search(String word) {
            char[] wordArr = word.toCharArray();
            return searchSubString(wordArr,0,root);
        }

        private boolean searchSubString(char[] word,int start,TrieNode subRoot){
            TrieNode cur = subRoot;
            for(int i=start;i<word.length;i++){
                if(word[i]!='.'){
                    if(!cur.children.containsKey(word[i])) return false;
                    cur = cur.children.get(word[i]);
                }
                else{
                    if(cur.children.isEmpty()) return false;
                    for(TrieNode node: cur.children.values()){
                        if(searchSubString(word, i+1, node)) return true;
                    }
                    return false;
                }
            }
            return cur.isEnd;
        }
    }

    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        System.out.println(wordDictionary.search("pad")); // return False
        System.out.println(wordDictionary.search("bad")); // return True
        System.out.println(wordDictionary.search(".ad")); // return True
        System.out.println(wordDictionary.search("b..")); // return True
    }

}
