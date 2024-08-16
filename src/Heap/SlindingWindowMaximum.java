package Heap;

import java.util.ArrayDeque;
import java.util.Arrays;

public class SlindingWindowMaximum {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int res[]=new int[nums.length-k+1];
        int j=0;
        ArrayDeque<Integer> queue=new ArrayDeque();
        for(int i=0;i<nums.length;i++){
            while(!queue.isEmpty()&&nums[queue.getLast()]<nums[i]){
                queue.removeLast();
            }
            queue.addLast(i);
            if(queue.getFirst()+k==i){
                queue.removeFirst();
            }
            if(i>=k-1){
                res[j++]=nums[queue.getFirst()];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int arr[]={1,3,-1,-3,5,3,6,7};
        int k=3;
        System.out.println(Arrays.toString(maxSlidingWindow(arr,k)));
    }
}
