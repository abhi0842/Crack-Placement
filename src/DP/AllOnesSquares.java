package DP;

public class AllOnesSquares {
    public static int countSquares(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = matrix[i][j];
                } else if (matrix[i][j] == 1) {
                    dp[i][j] = Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1])) + 1;
                }

                count += dp[i][j];
            }
        }
        return count;

    }

    public static void main(String[] args) {
        int arr[][]={{0,1,1,1},{1,1,1,1},{0,1,1,1}};
        System.out.println(countSquares(arr));

    }
}
