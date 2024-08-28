package Graph;

import java.util.LinkedList;
import java.util.Queue;

public class StepsbyKnight {
    private static final int[] rowMoves = {-2, -1, 1, 2, 2, 1, -1, -2};
    private static final int[] colMoves = {1, 2, 2, 1, -1, -2, -2, -1};

    //Function to find out minimum steps Knight needs to reach target position.
    public int minStepToReachTarget(int KnightPos[], int TargetPos[], int N)
    {


        // Convert positions to 0-based indexing
        int startX = KnightPos[0] - 1;
        int startY = KnightPos[1] - 1;
        int targetX = TargetPos[0] - 1;
        int targetY = TargetPos[1] - 1;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startX, startY, 0});

        // Visited array
        boolean[][] visited = new boolean[N][N];
        visited[startX][startY] = true;

        // BFS loop
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int dist = current[2];


            if (x == targetX && y == targetY) {
                return dist;
            }
            // Explore all 8 possible moves
            for (int i = 0; i < 8; i++) {
                int newX = x + rowMoves[i];
                int newY = y + colMoves[i];
                if (isValid(newX, newY, N) && !visited[newX][newY]) {
                    visited[newX][newY] = true;
                    queue.add(new int[]{newX, newY, dist + 1});
                }
            }
        }

        return -1;
    }


    private static boolean isValid(int x, int y, int N) {
        return (x >= 0 && x < N && y >= 0 && y < N);
    }
}
