package Backtracking;

public class McolouringProblem {
    private static boolean graphColoringUtil(boolean[][] graph, int m, int[] color, int vertex) {
        if (vertex == graph.length) {
            return true;
        }
        for (int c = 1; c <= m; c++) {
            if (isSafe(vertex, graph, color, c)) {
                color[vertex] = c;
                if (graphColoringUtil(graph, m, color, vertex + 1)) {
                    return true;
                }
                color[vertex] = 0;
            }
        }

        return false;
    }
    private static boolean isSafe(int vertex, boolean[][] graph, int[] color, int c) {
        for (int i = 0; i < graph.length; i++) {
            if (graph[vertex][i] && color[i] == c) {
                return false;
            }
        }
        return true;
    }
    public boolean graphColoring(boolean graph[][], int m, int n) {
        int[] color = new int[graph.length];
        if (graphColoringUtil(graph, m, color, 0)) {
            return true;
        } else {
            return false;
        }
    }

}
