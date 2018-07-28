package Trie;

public class TrieNode {

    boolean isWord;
    TrieNode[] key;

    public TrieNode() {

        this.isWord = false;
        this.key = new TrieNode[26];
    }

}
