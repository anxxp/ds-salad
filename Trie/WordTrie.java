package Trie;

public class WordTrie {

    public TrieNode root = new TrieNode();

    public static void main(String args[]){

        WordTrie wordList = new WordTrie();
        wordList.insertWord("anoop");
        wordList.insertWord("an");

        System.out.println(wordList.checkIfValidWord("oop"));
        System.out.println(wordList.checkIfValidWord("anoop"));

    }

    public void insertWord(String word){
        /**
         * We first split the word into a CHARACTER ARRAY
         * */
        char [] wordChar = word.toCharArray();

        /**
         * We start with ROOT as currentNode.
         * We then iterate over the CHARACTERS of the WORD
         * We find the INDEX of the CHARACTER in the currentNode.
         * If NODE at INDEX is NULL then we create a NEW NODE.
         * Then we mark NODE at INDEX as currentNode
         *
         * Once we are done with the iteration then in the last
         * currentNode we set the isWord flag TRUE
         * */
        TrieNode currentNode = root;

        for(int i=0;i<wordChar.length;i++){

            int index = wordChar[i] - 'a';
            if(currentNode.key[index] == null){
                currentNode.key[index] = new TrieNode();
            }
            currentNode = currentNode.key[index];

        }
        currentNode.isWord = true;
    }

    public boolean checkIfValidWord(String word){

        char[] wordChar = word.toCharArray();
        TrieNode currentNode = root;

        int i=0;
        int index;
        /**
         * We navigate through the TRIE till we have characters in the WORD.
         * During the traversal if we encounter NULL then there is no point in
         * iterating over the remaining characters of the word.
         *
         * When we are done with the WHILE loop, the if currentNode is :
         *  NULL -> The word is not found
         *  NOT NULL -> Then w have to check the isWord flag
         *
         * */
        while(currentNode!=null && i < wordChar.length){
            index = wordChar[i++] - 'a';
            currentNode = currentNode.key[index];
        }
        return currentNode!=null?currentNode.isWord:false;
    }
}
