package Heap;

import java.util.HashSet;
import java.util.PriorityQueue;

public class UglyNumber {
    public static int nthUglyNumber(int n) {
        PriorityQueue<Long> minHeap = new PriorityQueue<>();
        HashSet<Long> seen = new HashSet<>();
        minHeap.offer(1L);
        seen.add(1L);

        long current = 1;

        for (int i = 0; i < n; i++) {

            current = minHeap.poll();


            long Ugly2 = current * 2;
            long Ugly3 = current * 3;
            long Ugly5 = current * 5;

            if (seen.add(Ugly2)) {
                minHeap.offer(Ugly2);
            }
            if (seen.add(Ugly3)) {
                minHeap.offer(Ugly3);
            }
            if (seen.add(Ugly5)) {
                minHeap.offer(Ugly5);
            }
        }

        return (int) current;
    }

    public static void main(String[] args) {
        int n=10;
        System.out.println(nthUglyNumber(n));
    }
}
