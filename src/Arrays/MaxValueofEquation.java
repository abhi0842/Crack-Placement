package Arrays;

import java.util.Deque;
import java.util.LinkedList;

public class MaxValueofEquation {
    public static int findMaxValueOfEquation(int[][] points, int k) {
        Deque<Integer> q = new LinkedList<>();
        int maxValue = Integer.MIN_VALUE;

        for (int j = 0; j < points.length; j++) {
            int xj = points[j][0];
            int yj = points[j][1];
            while (!q.isEmpty() && xj - points[q.peekFirst()][0] > k) {
                q.pollFirst();
            }
            if (!q.isEmpty()) {
                int i = q.peekFirst();
                maxValue = Math.max(maxValue, yj + xj + points[i][1] - points[i][0]);
            }
            while (!q.isEmpty() && yj - xj >= points[q.peekLast()][1] - points[q.peekLast()][0]) {
                q.pollLast();
            }
            q.offerLast(j);
        }

        return maxValue;
    }

    public static void main(String[] args) {
        int arr[][]={{1,3},{2,0},{5,10},{6,-10}};
        int k=1;
        System.out.println(findMaxValueOfEquation(arr,k));

    }
}
