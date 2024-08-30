package Greedy;

import java.util.*;

public class CHOCOLAChocolate {
    public static int minCost(int[] verticalCuts, int[] horizontalCuts) {
        // Sort the costs in descending order
        Arrays.sort(verticalCuts);
        Arrays.sort(horizontalCuts);
        int m = verticalCuts.length;
        int n = horizontalCuts.length;
        Integer[] vCuts = Arrays.stream(verticalCuts).boxed().toArray(Integer[]::new);
        Integer[] hCuts = Arrays.stream(horizontalCuts).boxed().toArray(Integer[]::new);
        Arrays.sort(vCuts, Collections.reverseOrder());
        Arrays.sort(hCuts, Collections.reverseOrder());

        int hCount = 1;
        int vCount = 1;
        int i = 0, j = 0;
        int totalCost = 0;

        while (i < m && j < n) {
            if (vCuts[i] >= hCuts[j]) {
                totalCost += vCuts[i] * hCount;
                vCount++;
                i++;
            } else {
                totalCost += hCuts[j] * vCount;
                hCount++;
                j++;
            }
        }

        // If there are any remaining cuts
        while (i < m) {
            totalCost += vCuts[i] * hCount;
            i++;
        }

        while (j < n) {
            totalCost += hCuts[j] * vCount;
            j++;
        }

        return totalCost;
    }

    public static void main(String[] args) {
        int[] verticalCuts = {2, 1, 3, 1, 4};
        int[] horizontalCuts = {4, 1, 2};
        System.out.println(minCost(verticalCuts, horizontalCuts)); // Output: 42
    }
}
