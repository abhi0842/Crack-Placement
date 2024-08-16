package Heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class MinimumNumberofRefuelingStops {
    public static int minRefuelStops(int target, int startFuel, int[][] stations) {
        int i=0;
        int curr=startFuel;
        int res;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(res=0;curr<target;res++){
            while(i<stations.length&&stations[i][0]<=curr)
                maxHeap.add(stations[i++][1]);
            if(maxHeap.isEmpty())
                return -1;
            curr+=maxHeap.poll();

        }
        return res;
    }

    public static void main(String[] args) {
        int target=100;
        int startfuel=10;
        int arr[][]={{10,60},{20,30},{30,30},{60,40}};

        System.out.println(minRefuelStops(target,startfuel,arr));
    }
}
