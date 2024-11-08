package Trees;

public class MinimumCostTreeFromLeafValues {
    public int mctFromLeafValues(int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n][n];
        int[][] maxArr = new int[n][n];
        for (int i = 0; i < n; i++) {
            maxArr[i][i] = arr[i];
            for (int j = i + 1; j < n; j++) {
                maxArr[i][j] = Math.max(maxArr[i][j-1], arr[j]);
            }
        }

        for (int len = 1; len < n; len++) {
            for (int i = 0; i + len < n; i++) {
                int j = i + len;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    int cost = dp[i][k] + dp[k+1][j] + maxArr[i][k] * maxArr[k+1][j];
                    dp[i][j] = Math.min(dp[i][j], cost);
                }
            }
        }

        return dp[0][n-1];}
}
