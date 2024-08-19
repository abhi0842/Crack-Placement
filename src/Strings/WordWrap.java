package Strings;
import java.util.*;
public class WordWrap {
    public static int solveWordWrapRec(int[] nums, int k, int i,int dp[]) {
        int n = nums.length;
        if (i >= n) {
            return 0;
        }
        if(dp[i] != -1) {
            return dp[i];
        }
        int minCost = Integer.MAX_VALUE;
        int currLength = 0;

        for (int j = i; j < n; j++) {
            currLength += nums[j];

            if (currLength > k) {
                break;
            }
            int extraSpaces = k - currLength;
            int cost = (j == n - 1) ? 0 : extraSpaces * extraSpaces;
            int totalCost = cost + solveWordWrapRec(nums, k, j + 1,dp);
            minCost = Math.min(minCost, totalCost);

            currLength++;
        }
        dp[i] = minCost;
        return minCost;
    }


    public static int solveWordWrap(int[] nums, int k) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return solveWordWrapRec(nums, k, 0,dp);
    }
}
