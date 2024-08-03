package Graph;

import java.util.ArrayList;

public class cycleInUndirectedgraph {
    private static boolean dfs(int node, int parent, boolean[] visited, ArrayList<ArrayList<Integer>> adj) {
        visited[node] = true;

        for (int neighbor : adj.get(node)) {
            if (visited[neighbor]&&neighbor!=parent) {
                return true;
            } else if (!visited[neighbor]) {
                if (dfs(neighbor, node, visited, adj)) {
                    return true;
                }
            }
        }

        return false;
    }
    // Function to detect cycle in an undirected graph.
    public static boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V];

        // Perform DFS from each vertex
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (dfs(i, -1, visited, adj)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        int V=5;
        System.out.println(isCycle(V,adj));
    }
}
