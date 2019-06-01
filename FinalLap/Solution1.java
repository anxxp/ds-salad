package FinalLap;

import java.util.*;

public class Solution1 {

    public static void main(String args[]){

        List<List<Integer>> allLocations = new ArrayList<>();
        allLocations.add(Arrays.asList(1,2));
        allLocations.add(Arrays.asList(3,4));
        allLocations.add(Arrays.asList(1,-1));
        List<List<Integer>> answer = Solution1.closestLocations(3,allLocations,2);
        System.out.println(answer);
    }

    static List<List<Integer>>  closestLocations(int totalCrates,
                                         List<List<Integer>> allLocations,
                                         int truckCapacity){


        class LocDistance implements Comparable{
            Double distance;
            Integer loc;

            public LocDistance(Double distance, Integer loc) {
                this.distance = distance;
                this.loc = loc;
            }

            public void print(){
                System.out.println(loc+" : "+distance);
            }

            @Override
            public int compareTo(Object o) {
                return (distance.compareTo(((LocDistance)o).distance));
            }
        }

        List<LocDistance> locDistances = new LinkedList<>();


        List<Integer> currLoc;
        Double distance;

        for(int i=0;i<truckCapacity;i++){
            currLoc = allLocations.get(i);
            distance = Math.sqrt(currLoc.get(0).intValue()*currLoc.get(0).intValue() +currLoc.get(1).intValue()*currLoc.get(1).intValue());
            LocDistance locDist = new LocDistance(distance,i);
            locDistances.add(locDist);
        }

        Collections.sort(locDistances);

        for(int i=truckCapacity;i<allLocations.size();i++){
            currLoc = allLocations.get(i);
            distance = Math.sqrt(currLoc.get(0).intValue()*currLoc.get(0).intValue() +currLoc.get(1).intValue()*currLoc.get(1).intValue());
            if(distance >= locDistances.get(truckCapacity-1).distance){
                continue;
            }
            LocDistance locDist = new LocDistance(distance,i);
            int j=0;
            while (locDist.compareTo(locDistances.get(j))>0 && j<locDistances.size()-1){
               j++;
            }
            locDistances.add(j,locDist);
            locDistances.remove(locDistances.size()-1);
        }

        List<List<Integer>> locations = new ArrayList<>();
        for(int i=0;i<locDistances.size();i++){
            locations.add(allLocations.get(locDistances.get(i).loc.intValue()));
        }
        return locations;
    }
}
