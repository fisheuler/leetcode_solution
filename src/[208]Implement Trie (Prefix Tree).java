//A trie (pronounced as "try") or prefix tree is a tree data structure used to e
//fficiently store and retrieve keys in a dataset of strings. There are various ap
//plications of this data structure, such as autocomplete and spellchecker. 
//
// Implement the Trie class: 
//
// 
// Trie() Initializes the trie object. 
// void insert(String word) Inserts the string word into the trie. 
// boolean search(String word) Returns true if the string word is in the trie (i
//.e., was inserted before), and false otherwise. 
// boolean startsWith(String prefix) Returns true if there is a previously inser
//ted string word that has the prefix prefix, and false otherwise. 
// 
//
// 
// Example 1: 
//
// 
//Input
//["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
//[[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
//Output
//[null, null, true, false, true, null, true]
//
//Explanation
//Trie trie = new Trie();
//trie.insert("apple");
//trie.search("apple");   // return True
//trie.search("app");     // return False
//trie.startsWith("app"); // return True
//trie.insert("app");
//trie.search("app");     // return True
// 
//
// 
// Constraints: 
//
// 
// 1 <= word.length, prefix.length <= 2000 
// word and prefix consist only of lowercase English letters. 
// At most 3 * 104 calls in total will be made to insert, search, and startsWith
//. 
// 
// Related Topics Hash Table String Design Trie 
// 👍 5111 👎 77


//leetcode submit region begin(Prohibit modification and deletion)
class Trie {

    private TrieNode root;
    public int R = 26;
    public class TrieNode{
        TrieNode[] links;
        boolean end;
        public TrieNode(){
            links = new TrieNode[R];
        }

        public boolean contains(char ch){
            return links[ch-'0'] !=null;
        }

        public TrieNode getChar(char ch){
            return links[ch-'0'];
        }

        public void put(char ch,TrieNode node){
            links[ch-'0'] = node;
        }

        public void setEnd() {
            end = true;
        }
        public boolean isEnd() {
            return end;
        }
    }

    /** Initialize your data structure here. */
    public Trie() {
        root  = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        if(word==null || word.length()<=0){
            return;
        }

        TrieNode node = root;
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            if(node.contains(ch)){

            }else{
                node.put(ch,new TrieNode());
            }
            node = node.getChar(ch);
        }
        node.setEnd();
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        if(word==null || word.length() <= 0){
            return false;
        }
        TrieNode node = root;
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            node = node.getChar(ch);
            if(node==null){
                return false;
            }
        }
        return node.isEnd();
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        if(prefix==null || prefix.length() <= 0){
            return false;
        }
        TrieNode node = root;
        int i=0;
        for(;i<prefix.length();i++){
            char ch = prefix.charAt(i);
            node = node.getChar(ch);
            if(node==null){
                break;
            }
        }
        return i>0;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
//leetcode submit region end(Prohibit modification and deletion)
