package Heap;

import java.util.*;

public class MinimumCosttoHireKWorkers {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int n = quality.length;
        Worker[] workers = new Worker[n];

        // Create an array of workers with their quality and wage ratio
        for (int i = 0; i < n; i++) {
            workers[i] = new Worker(quality[i], wage[i]);
        }

        // Sort workers by their wage to quality ratio
        Arrays.sort(workers, (a, b) -> Double.compare(a.ratio(), b.ratio()));

        // Use a max heap to maintain the smallest k qualities
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        int totalQuality = 0;
        double minCost = Double.MAX_VALUE;

        // Iterate over sorted workers
        for (Worker worker : workers) {
            // Add the current worker's quality to the total and to the heap
            maxHeap.offer(worker.quality);
            totalQuality += worker.quality;

            // If the heap size exceeds k, remove the highest quality worker
            if (maxHeap.size() > k) {
                totalQuality -= maxHeap.poll();
            }

            // If we have exactly k workers, calculate the minimum cost
            if (maxHeap.size() == k) {
                double cost = totalQuality * worker.ratio();
                minCost = Math.min(minCost, cost);
            }
        }

        return minCost;
    }

    private static class Worker {
        int quality, wage;

        Worker(int quality, int wage) {
            this.quality = quality;
            this.wage = wage;
        }

        // Calculate the wage to quality ratio
        double ratio() {
            return (double) wage / quality;
        }
    }
}
