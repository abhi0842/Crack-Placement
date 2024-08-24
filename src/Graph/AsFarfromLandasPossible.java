package Graph;

import java.util.LinkedList;
import java.util.Queue;

public class AsFarfromLandasPossible {
    public int maxDistance(int[][] grid) {
        int n = grid.length;
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    queue.add(new int[]{i, j});
                }
            }
        }

        if (queue.size() == 0 || queue.size() == n * n) {
            return -1;
        }

        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int maxDistance = -1;
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int x = cell[0], y = cell[1];

            for (int[] dir : directions) {
                int newX = x + dir[0];
                int newY = y + dir[1];
                if (newX >= 0 && newX < n && newY >= 0 && newY < n && grid[newX][newY] == 0) {
                    grid[newX][newY] = grid[x][y] + 1;
                    maxDistance = Math.max(maxDistance, grid[newX][newY] - 1);
                    queue.add(new int[]{newX, newY});
                }
            }
        }

        return maxDistance;
    }
}
