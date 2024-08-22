package Backtracking;
import java.util.*;
public class PartitionarraytoKubsets {
    public boolean isKPartitionPossible(int[] a, int n, int k) {
        int totalSum = 0;

        // Calculate the total sum of the array
        for (int i : a) {
            totalSum += i;
        }

        // If the total sum is not divisible by k, we can't partition the array
        if (totalSum % k != 0) {
            return false;
        }

        int targetSum = totalSum / k;
        Arrays.sort(a);

        // If the largest number is greater than targetSum, partitioning is impossible
        if (a[a.length - 1] > targetSum) {
            return false;
        }

        boolean[] visited = new boolean[a.length];

        // Start the backtracking process
        return canPartition(a, visited, 0, k, 0, targetSum);
    }

    private boolean canPartition(int[] nums, boolean[] visited, int startIndex, int k, int currentSum, int targetSum) {
        // If only one subset remains, it's guaranteed to have the target sum
        if (k == 1) {
            return true;
        }

        // If the current subset reaches the target sum, move to the next subset
        if (currentSum == targetSum) {
            return canPartition(nums, visited, 0, k - 1, 0, targetSum);
        }

        // Try to add each unused element to the current subset
        for (int i = startIndex; i < nums.length; i++) {
            if (!visited[i] && currentSum + nums[i] <= targetSum) {
                visited[i] = true;

                // Recursively check if adding this element leads to a solution
                if (canPartition(nums, visited, i + 1, k, currentSum + nums[i], targetSum)) {
                    return true;
                }

                // Backtrack if it doesn't lead to a solution
                visited[i] = false;
            }
        }

        return false; // If no valid partitioning is found, return false
    }
}
