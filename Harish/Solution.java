package Harish;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public static void main(String args[]){

        List<List<Integer>> forwardRouteList = new ArrayList<>();
        forwardRouteList.add(Arrays.asList(1,3000));
        forwardRouteList.add(Arrays.asList(2,5000));
        forwardRouteList.add(Arrays.asList(3,7000));
        forwardRouteList.add(Arrays.asList(4,10000));
        List<List<Integer>> returnRouteList = new ArrayList<>();
        returnRouteList.add(Arrays.asList(1,2000));
        returnRouteList.add(Arrays.asList(2,3000));
        returnRouteList.add(Arrays.asList(3,4000));
        returnRouteList.add(Arrays.asList(4,5000));
        int maxTravelDist =10000;
        System.out.println(optimalUtilization(maxTravelDist,forwardRouteList,returnRouteList));
    }

    public static List<List<Integer>> optimalUtilization(int maxTravelDist,
                                                         List<List<Integer>> forwardRouteList,
                                                         List<List<Integer>> returnRouteList){

        List<List<Integer>> resultList = new ArrayList<>();
        List<Integer> maxSofar = new ArrayList<>(1);
        maxSofar.add(0);
        for(int i=0;i<forwardRouteList.size();i++){
            for(int j=0;j<returnRouteList.size();j++){
                optimalUtilization(maxTravelDist, forwardRouteList,returnRouteList,i,j,maxSofar,resultList);
            }

        }
        return resultList;
    }

    private static void optimalUtilization(int maxTravelDist,
                                           List<List<Integer>> forwardRouteList,
                                           List<List<Integer>> returnRouteList,
                                           int forwardRoute,
                                           int returnRoute,
                                           List<Integer>  maxSofar,
                                           List<List<Integer>> result) {


        int forwardDist = forwardRouteList.get(forwardRoute).get(1);
        int returnDist = returnRouteList.get(returnRoute).get(1);

        if(forwardDist+returnDist > maxTravelDist){
            return;
        }

        if(maxSofar.get(0)==0){
            maxSofar.add(0,forwardDist+returnDist);
            result.add(Arrays.asList(forwardRouteList.get(forwardRoute).get(0),returnRouteList.get(returnRoute).get(0)));
        }

        if(forwardDist+returnDist < maxSofar.get(0)){
            return;
        }

        if(forwardDist+returnDist == maxSofar.get(0)){
            result.add(Arrays.asList(forwardRouteList.get(forwardRoute).get(0),returnRouteList.get(returnRoute).get(0)));
        }

        if(forwardDist+returnDist > maxSofar.get(0)){
            result.clear();
            maxSofar.add(0,forwardDist+returnDist);
            result.add(Arrays.asList(forwardRouteList.get(forwardRoute).get(0),returnRouteList.get(returnRoute).get(0)));
        }

    }
}
