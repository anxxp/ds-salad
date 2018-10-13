package Backtracking;

import Trie.Trie;
import Trie.TrieNodeHM;

public class WordBreakingAllPossibility {

    int[] breaks;
    String input;
    Trie dictionary;

    public WordBreakingAllPossibility(String input){
        this.input = input;
        breaks = new int[input.length()];
        this.dictionary = new Trie();
    }

    public static void main(String args[]){
        String input ="ilovesamsungmobile";
        WordBreakingAllPossibility wordBreaking = new WordBreakingAllPossibility(input);
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
        for(int x=0;x<input.length(); x++){
            System.out.print(input.charAt(x)+" ");
        }
        System.out.println();
        for(int x=0;x<input.length(); x++){
            System.out.print(breaks[x]+" ");
        }
    }

    private boolean breakWord( int i) {
        if(i == input.length()){

            return true;
        }

        String word;
        //TrieNodeHM currentPosition;
        for(int j=i ; j< input.length() ;j++){
            word = input.substring(i,j+1);
            // currentPosition = dictionary.getTrieNodeIfValidWord(word);
            // if(currentPosition != null && currentPosition.isWord){
            if(dictionary.searchWord(word)){
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
