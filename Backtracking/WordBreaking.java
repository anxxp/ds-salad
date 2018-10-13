package Backtracking;

import Trie.TrieNode;
import Trie.WordTrie;

public class WordBreaking {

    int[] breaks;
    String input;
    WordTrie dictionary;

    public WordBreaking(String input){
        this.input = input;
        breaks = new int[input.length()];
        this.dictionary = new WordTrie();
    }

    public static void main(String args[]){
        String input ="ilovesamsungmobile";
        WordBreaking wordBreaking = new WordBreaking(input);
        wordBreaking.dictionary.insertWord("i");
        wordBreaking.dictionary.insertWord("love");
        //wordBreaking.dictionary.insertWord("sam");
        wordBreaking.dictionary.insertWord("samsung");
        wordBreaking.dictionary.insertWord("sung");
        wordBreaking.dictionary.insertWord("mobile");
        wordBreaking.wordBreaker();

    }

    private void wordBreaker() {

        System.out.println(breakWord(0));
    }

    private boolean breakWord( int i) {
        if(i == input.length()){
            for(int x=0;x<input.length(); x++){
                System.out.print(input.charAt(x)+" ");
            }
            System.out.println();
            for(int x=0;x<input.length(); x++){
                System.out.print(breaks[x]+" ");
            }
            return true;
        }

        String word;
        TrieNode currentPosition;
        for(int j=i ; j< input.length() ;j++){
            word = input.substring(i,j+1);
            //currentPosition = dictionary.getTrieNodeIfValidWord(word);
            // if(currentPosition != null && currentPosition.isWord){
             if(dictionary.checkIfValidWord(word)){
               breaks[j] =1;
               if(breakWord(j+1)){
                   return true;
               }
               breaks[j] =0;
            }
        }
        return false;
    }
}
