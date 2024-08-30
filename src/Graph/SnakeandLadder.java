package Graph;

import java.util.LinkedList;
import java.util.Queue;

public class SnakeandLadder {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        int[] pos = new int[n * n + 1];

        // Map the 2D board to 1D array pos
        boolean leftToRight = true;
        int index = 1;
        for (int i = n - 1; i >= 0; i--) {
            if (leftToRight) {
                for (int j = 0; j < n; j++) {
                    pos[index++] = board[i][j];
                }
            } else {
                for (int j = n - 1; j >= 0; j--) {
                    pos[index++] = board[i][j];
                }
            }
            leftToRight = !leftToRight;
        }

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n * n + 1];
        queue.offer(1);
        visited[1] = true;
        int moves = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int curr = queue.poll();
                if (curr == n * n) return moves;

                for (int next = curr + 1; next <= Math.min(curr + 6, n * n); next++) {
                    int destination = (pos[next] == -1) ? next : pos[next];
                    if (!visited[destination]) {
                        visited[destination] = true;
                        queue.offer(destination);
                    }
                }
            }
            moves++;
        }

        return -1;
    }
}
