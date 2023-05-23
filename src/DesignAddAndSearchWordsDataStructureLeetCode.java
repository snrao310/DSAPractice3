import sun.text.normalizer.Trie;

import java.util.HashMap;

public class DesignAddAndSearchWordsDataStructureLeetCode {

    static class WordDictionary {
        class TrieNode{
            boolean isEnd;
            HashMap<Character,TrieNode> children;

            public TrieNode(boolean isEnd){
                this.isEnd = isEnd;
                this.children = new HashMap<>();
            }
        }

        TrieNode root;

        public WordDictionary() {
            this.root = new TrieNode(false);
        }

        public void addWord(String word) {
            char[] wordArray = word.toCharArray();
            TrieNode lastNode = this.root;
            for(char c:wordArray){
                HashMap<Character,TrieNode> children = lastNode.children;
                if(children.containsKey(c)){
                    lastNode =children.get(c);
                }
                else{
                    TrieNode newNode = new TrieNode(false);
                    children.put(c,newNode);
                    lastNode = newNode;
                }
            }
            lastNode.isEnd = true;
        }

        public boolean search(String word){
            return searchTrie(word.toCharArray(),0,this.root);
        }

        public boolean searchTrie(char[] wordArray,int index, TrieNode root) {
            if(index>=wordArray.length){
                return root.isEnd;
            }
            HashMap<Character,TrieNode> children = root.children;
            char curChar = wordArray[index];
            if(curChar != '.'){
                if(children.containsKey(curChar)){
                    return searchTrie(wordArray,index+1,children.get(curChar));
                }
                else return false;
            }
            else{
                for(TrieNode child: children.values()){
                    boolean found = searchTrie(wordArray,index+1,child);
                    if(found) return true;
                }
            }
            return false;
        }
    }

    public static void main(String[] args){
        WordDictionary wd = new WordDictionary();
        wd.addWord("apple");
        wd.addWord("app");
        wd.addWord("ball");
        wd.addWord("cat");
        System.out.println("apple :"+wd.search("apple"));
        System.out.println("ball :"+wd.search("ball"));
        System.out.println("cat :"+wd.search("cat"));
        System.out.println("dog :"+wd.search("dog"));
        System.out.println("app :"+wd.search("app"));
        System.out.println("ca :"+wd.search("ca"));
        System.out.println("catamaran :"+wd.search("catamaran"));
        System.out.println(".pp.e :"+wd.search(".pp.e"));
    }
}
