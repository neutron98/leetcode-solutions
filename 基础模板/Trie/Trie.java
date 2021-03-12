class Trie {
    private static class TrieNode {
        private char c;
        private boolean isWord;
        private TrieNode[] children;
        
        TrieNode() {
            this.children = new TrieNode[26];
            this.isWord = false;
        }
        
        TrieNode(char c) {
            this();
            this.c = c;
        }
    }
    
    private TrieNode root;
    
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode p = root;
        for (int i = 0; i < word.length(); i++) {
            int index = (int)(word.charAt(i) - 'a');
            if (p.children[index] == null)
                p.children[index] = new TrieNode(word.charAt(i));
            p = p.children[index];
        }
        p.isWord = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = find(word);
        return node != null && node.isWord;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode node = find(prefix);
        return node != null;
    }
    /** Return the end TrieNode if the prefix exists.**/
    private TrieNode find(String prefix) {
        TrieNode p = root;
        for(int i = 0; i < prefix.length(); i++) {
            int index = (int)(prefix.charAt(i) - 'a');
            if (p.children[index] == null) return null;
            p = p.children[index];
        }
        return p;
    }
}
