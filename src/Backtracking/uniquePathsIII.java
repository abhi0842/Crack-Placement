package Backtracking;

public class uniquePathsIII {
    private int Paths = 0;
    private int walkables = 0;
    public int uniquePathsIII(int[][] grid) {
        int startX = 0, startY = 0;
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    startX = i;
                    startY = j;
                }
                //if its not -1 then its walkable
                if (grid[i][j] != -1) {
                    walkables++;
                }
            }
        }
        helper(grid, startX, startY, walkables);

        return Paths;
    }
    private void helper(int[][] grid, int x, int y, int remainingSquares) {

        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] == -1) {
            return;
        }

        if (grid[x][y] == 2) {
            if (remainingSquares == 1) {
                Paths++;
            }
            return;
        }

        int temp = grid[x][y];
        grid[x][y] = -1;

        helper(grid, x + 1, y, remainingSquares - 1);
        helper(grid, x - 1, y, remainingSquares - 1);
        helper(grid, x, y + 1, remainingSquares - 1);
        helper(grid, x, y - 1, remainingSquares - 1);
        grid[x][y] = temp;
    }
}
