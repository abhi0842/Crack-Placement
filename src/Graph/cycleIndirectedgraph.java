package Graph;

import java.util.ArrayList;

public class cycleIndirectedgraph {
    private static boolean dfs(int node, boolean[] visited, ArrayList<ArrayList<Integer>> adj,boolean[]rec) {
        visited[node] = true;
        rec[node]=true;
        for (int neighbor : adj.get(node)) {
            if (rec[neighbor]==true) {
                return true;
            } else if (!visited[neighbor]) {
                if (dfs(neighbor,visited, adj,rec)) {
                    return true;
                }
            }
        }
        rec[node]=false;
        return false;
    }
    // Function to detect cycle in a directed graph.
    public static  boolean iscyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V];
        boolean []rec=new boolean[V];
        // Perform DFS from each vertex
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (dfs(i,visited, adj,rec)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        int V=5;
        System.out.println(iscyclic(V,adj));
    }
}
