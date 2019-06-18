package FinalLap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution2 {

    public static void main(String args[]){
        List<String> answer = Solution2.allValidSubString("aaabbc",2);
        System.out.println(answer);
    }

    public static List<String> allValidSubString(String str,int k){
        List<String> allValidStrings = new ArrayList<>();
        char[] input = str.toLowerCase().toCharArray();
        Map<Character,Integer> countMap = new HashMap<>();

        Character c;
        Integer count = null;
        for(int i =0;i<k;i++){
            c = input[i];
            count = countMap.get(c);
            count = count == null ?  1 : count + 1;
            countMap.put(c, count);
        }

        Character outgoing;
        Character incoming;
        Integer outCount;
        Integer inCount;
        for(int i=k;i<input.length;i++){
            outgoing = input[i-k];
           outCount = countMap.get(outgoing);

           if(outCount==1){
               countMap.remove(outgoing);
           }else{
               countMap.put(outgoing,count-1);
           }
           incoming = input[i];
           inCount = countMap.get(incoming);
           if(inCount==null){
               inCount=0;
           }
           countMap.put(input[i],++inCount);

           if(countMap.keySet().size() == k){
               allValidStrings.add(str.substring(i-k+1,i+1));
           }

        }

        return allValidStrings;
    }


}
