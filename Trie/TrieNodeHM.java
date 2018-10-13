package Trie;

import java.util.HashMap;

public class TrieNodeHM {

    public HashMap<Character,TrieNodeHM> children;
    public boolean isWord;

    public TrieNodeHM(){
        children = new HashMap<>();
        isWord = false;
    }
}
