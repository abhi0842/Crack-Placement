package DP;
import java.util.*;
public class minimumPathSum {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] memo = new int[m][n];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return minPathSumHelper(grid, 0, 0, memo);
    }
    private int minPathSumHelper(int[][] grid, int i, int j,int memo[][]) {
        if (i == grid.length - 1 && j == grid[0].length - 1) {
            return grid[i][j];
        }
        if (i >= grid.length || j >= grid[0].length) {
            return Integer.MAX_VALUE;
        }
        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        int rightMove = minPathSumHelper(grid, i, j + 1,memo);
        int downMove = minPathSumHelper(grid, i + 1, j,memo);
        memo[i][j]= grid[i][j] + Math.min(rightMove, downMove);
        return memo[i][j];
    }

}
