package DP;

public class RemoveBoxes {
    public static int removeBoxes(int[] boxes) {
        int n = boxes.length;
        int[][][] dp = new int[n][n][n];

        return dpHelper(boxes, 0, n - 1, 0, dp);
    }

    private static int dpHelper(int[] boxes, int i, int j, int k, int[][][] dp) {
        if (i > j) {
            return 0;
        }

        if (dp[i][j][k] != 0) {
            return dp[i][j][k];
        }
        int maxPoints = (k + 1) * (k + 1) + dpHelper(boxes, i, j - 1, 0, dp);

        for (int m = i; m < j; m++) {
            if (boxes[m] == boxes[j]) {
                maxPoints = Math.max(maxPoints, dpHelper(boxes, i, m, k + 1, dp) + dpHelper(boxes, m + 1, j - 1, 0, dp));
            }
        }

        dp[i][j][k] = maxPoints;
        return maxPoints;
    }

}
