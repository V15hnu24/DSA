public class LC211_DesignAndSearchWordsDataStructure {
    public static void main(String[] args) {
        String a = "abc...";
        System.out.println(a.substring(1));
    }
    TrieNode root;

//    public LC211_DesignAndSearchWordsDataStructure() {
//        root = new TrieNode();
//    }

    public void addWord(String word) {
        TrieNode cur = root;
        for(int i=0; i<word.length(); i++){
            if(!cur.containsKey(word.charAt(i))){
                cur.put(word.charAt(i) , new TrieNode());
            }
            cur = cur.get(word.charAt(i));
        }
        cur.setEnd();
    }

    public boolean search(String word) {
        TrieNode cur = root;
        for(int i=0; i<word.length(); i++){
            if(word.charAt(i) == '.'){
                return search_util(word.substring(i), cur);
            }
            if(!cur.containsKey(word.charAt(i))){
                return false;
            }
            cur = cur.get(word.charAt(i));
        }
        return cur.isEnd();
    }

    boolean search_util(String word, TrieNode cur){
        if(cur == null){
            return false;
        }
        if(word.length() == 1){
            return cur.isEnd();
        }
        for(int i=0; i<word.length(); i++){
            if(word.charAt(i) == '.'){
                for(int j =0; j<26; j++){
                    if(cur.ary[i] !=null){
                        if(search_util(word.substring(i), cur.ary[j])){
                            return true;
                        }
                    }
                }
                return false;
            }
            if(!cur.containsKey(word.charAt(i))){
                return false;
            }
            cur = cur.get(word.charAt(i));
        }
        return cur.isEnd();
    }
}
class TrieNode{
    TrieNode[] ary;
    boolean isEnd = false;
    public TrieNode(){
        ary = new TrieNode[26];
    }
    public TrieNode get(char c){
        return ary[c - 'a'];
    }
    public boolean containsKey(char c){
        return ary[c-'a'] != null;
    }
    public void setEnd() {
        isEnd = true;
    }
    public boolean isEnd() {
        return isEnd;
    }
    public void put(char ch, TrieNode node) {
        ary[ch -'a'] = node;
    }
}