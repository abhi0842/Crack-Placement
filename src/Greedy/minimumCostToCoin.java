package Greedy;
import java.util.*;

public class minimumCostToCoin {

    public static int minCost(int[] coin, int n, int k) {
        // Sort the coins in ascending order
        Arrays.sort(coin);

        // Calculate the minimum number of coins needed
        int coinsNeeded = (n + k) / (k + 1); // This replaces Math.ceil with integer arithmetic

        // Calculate the sum of the selected coins
        int sum = 0;
        for (int i = 0; i < coinsNeeded; i++) {
            sum += coin[i];
        }
        return sum;
}
}
