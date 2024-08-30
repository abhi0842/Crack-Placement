package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PrerequisiteTasks {
    public boolean isPossible(int N,int P, int[][] prerequisites)
    {
        // Create an adjacency list
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            adjList.add(new ArrayList<>());
        }

        // Fill the adjacency list and in-degree array
        int[] inDegree = new int[N];
        for (int[] prereq : prerequisites) {
            int dest = prereq[0];
            int src = prereq[1];
            adjList.get(src).add(dest);
            inDegree[dest]++;
        }

        // Initialize a queue and enqueue nodes with 0 in-degree
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        // Process nodes with 0 in-degree
        int completedCourses = 0;
        while (!queue.isEmpty()) {
            int course = queue.poll();
            completedCourses++;

            // Decrease the in-degree of adjacent nodes
            for (int neighbor : adjList.get(course)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }

        return completedCourses == N;
    }
}
