package Graph;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
class pair implements Comparable<pair> {
    int node;
    int wt;

    pair(int node, int wt) {
        this.node = node;
        this.wt = wt;
    }

    @Override
    public int compareTo(pair other) {
        return this.wt - other.wt;
    }
}
public class MinimumSpanningTree {
   public static int spanningTree(int V, int E, List<List<int[]>> adj) {
        PriorityQueue<pair> pq = new PriorityQueue<>();
        boolean[] vis = new boolean[V];
        int sum = 0;
        pq.add(new pair(0, 0));

        while (!pq.isEmpty()) {
            pair curr = pq.poll();
            int u = curr.node;
            if (!vis[u]) {
                vis[u] = true;
                sum += curr.wt;
                for (int[] neighbor : adj.get(u)) {
                    int v = neighbor[0];
                    int wt = neighbor[1];
                    if (!vis[v]) {
                        pq.add(new pair(v, wt));
                    }
                }
            }        }

        return sum;
    }

    public static void main(String[] args) {
        int V = 5; // Number of vertices
        int E = 7; // Number of edges

        // Initialize adjacency list
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Example graph
        adj.get(0).add(new int[]{1, 2});
        adj.get(1).add(new int[]{0, 2});
        adj.get(0).add(new int[]{3, 6});
        adj.get(3).add(new int[]{0, 6});
        adj.get(1).add(new int[]{3, 8});
        adj.get(3).add(new int[]{1, 8});
        adj.get(1).add(new int[]{2, 3});
        adj.get(2).add(new int[]{1, 3});
        adj.get(1).add(new int[]{4, 5});
        adj.get(4).add(new int[]{1, 5});
        adj.get(2).add(new int[]{4, 7});
        adj.get(4).add(new int[]{2, 7});
        int result = spanningTree(V, E, adj);
        System.out.println(result);
    }
    }

