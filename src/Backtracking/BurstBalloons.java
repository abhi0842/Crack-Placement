package Backtracking;

public class BurstBalloons {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] newNums = new int[n + 2];
        newNums[0] = 1;
        newNums[n + 1] = 1;
        for (int i = 1; i <= n; i++) {
            newNums[i] = nums[i - 1];
        }
        int[][] dp = new int[n + 2][n + 2];
        for (int length = 2; length < n + 2; length++) {
            for (int left = 0; left < n + 2 - length; left++) {
                int right = left + length;
                for (int k = left + 1; k < right; k++) {
                    dp[left][right] = Math.max(dp[left][right],
                            newNums[left] * newNums[k] * newNums[right] + dp[left][k] + dp[k][right]);
                }
            }
        }
        return dp[0][n + 1];
    }
}
