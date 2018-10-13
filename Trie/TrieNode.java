package Trie;

public class TrieNode {

    public boolean isWord;
    public TrieNode[] key;

    public TrieNode() {

        this.isWord = false;
        this.key = new TrieNode[26];
    }

}
