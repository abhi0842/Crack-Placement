package Heap;

import java.util.*;

public class KthFrequentElement {
    public static int[] topKFrequent(int[] nums, int k) {
        int []res=new int[k];
        Map<Integer,Integer> map=new HashMap<>();
        for(int i:nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        Queue<Integer> heap=new PriorityQueue<>((a, b)->map.get(a)-map.get(b));
        for(int key:map.keySet()){
            heap.add(key);
            if(heap.size()>k){
                heap.poll();
            }

        }
        while(k-->0){
            res[k]=heap.poll();
        }
        return res;
    }

    public static void main(String[] args) {
        int k=2;
        int [] arr={1,1,1,2,2,3};
        System.out.println(Arrays.toString(topKFrequent(arr,k)));
    }
}
