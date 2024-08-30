package SearchingSorting;

import java.util.*;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SwapstoSort {
    public static int minSwaps(int[] arr) {
        int n = arr.length;
        List<Pair> arrWithIndices = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arrWithIndices.add(new Pair(arr[i], i));
        }

        Collections.sort(arrWithIndices, Comparator.comparingInt(a -> a.value));

        boolean[] visited = new boolean[n];
        Arrays.fill(visited, false);

        int swaps = 0;

        for (int i = 0; i < n; i++) {
            if (visited[i] || arrWithIndices.get(i).index == i) {
                continue;
            }

            int cycleSize = 0;
            int j = i;

            while (!visited[j]) {
                visited[j] = true;
                j = arrWithIndices.get(j).index;
                cycleSize++;
            }
            if (cycleSize > 1) {
                swaps += (cycleSize - 1);
            }
        }

        return swaps;
    }
    static class Pair {
        int value, index;

        Pair(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }
}
