package Trie;

public class Trie {

    TrieNodeHM root;

    public Trie(){
        root = new TrieNodeHM();
    }

    public void insertWord(String word){

        TrieNodeHM current = root;

        for(int i=0;i<word.length();i++){
            Character ch = word.charAt(i);
            TrieNodeHM node = current.children.get(ch);
            if(node== null){
                node = new TrieNodeHM();
                current.children.put(ch,node);
            }
            current = node;
        }
        current.isWord = true;
    }

    public boolean searchWord(String word){

        TrieNodeHM current = root;
        for (int i=0;i<word.length();i++){
            Character ch = word.charAt(i);
            TrieNodeHM node = current.children.get(ch);
            if(node==null){
                return false;
            }
            current = node;
        }
        return current.isWord;
    }

    public TrieNodeHM getTrieNodeIfValidWord(String word){

        TrieNodeHM current = root;
        for (int i=0;i<word.length();i++){
            Character ch = word.charAt(i);
            TrieNodeHM node = current.children.get(ch);
            if(node==null){
                return new TrieNodeHM();
            }
            current = node;
        }
        return current;
    }
}
