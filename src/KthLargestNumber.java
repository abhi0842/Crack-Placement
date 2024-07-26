import java.util.PriorityQueue;

public class KthLargestNumber {
    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);
        for(int i:nums){
            minHeap.offer(i);
            if(minHeap.size()>k){
                minHeap.poll();
            }
        }

        return minHeap.peek();
    }

    public static void main(String[] args) {
        int arr[]={3,2,1,5,6,4};
        int k=2;
        System.out.println(findKthLargest(arr,k));
    }
}
