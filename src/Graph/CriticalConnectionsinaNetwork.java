package Graph;

import java.util.*;
import java.util.List;

public class CriticalConnectionsinaNetwork {
    private int time = 0;
    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (List<Integer> connection : connections) {
            int u = connection.get(0);
            int v = connection.get(1);
            graph[u].add(v);
            graph[v].add(u);
        }

        int[] discovery = new int[n];
        int[] low = new int[n];
        Arrays.fill(discovery, -1);

        for (int i = 0; i < n; i++) {
            if (discovery[i] == -1) {
                dfs(i, -1, graph, discovery, low);
            }
        }

        return result;
    }

    private void dfs(int u, int parent, List<Integer>[] graph, int[] discovery, int[] low) {
        discovery[u] = low[u] = ++time;

        for (int v : graph[u]) {
            if (v == parent) continue;

            if (discovery[v] == -1) {
                dfs(v, u, graph, discovery, low);
                low[u] = Math.min(low[u], low[v]);
                if (low[v] > discovery[u]) {
                    result.add(Arrays.asList(u, v));
                }
            } else {
                low[u] = Math.min(low[u], discovery[v]);
            }
        }
    }
}
