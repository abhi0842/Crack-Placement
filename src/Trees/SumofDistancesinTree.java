package Trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SumofDistancesinTree {
    private long resultBaseNode = 0;
    private int[] count;
    private int N;


    private int dfsBase(Map<Integer, List<Integer>> adj, int currNode, int prevNode, int currDepth) {
        int totalNode = 1;

        resultBaseNode += currDepth;

        List<Integer> children = adj.get(currNode);
        if (children != null) {
            for (int child : children) {
                if (child == prevNode) {
                    continue;
                }

                totalNode += dfsBase(adj, child, currNode, currDepth + 1);
            }
        }

        // Store count of subtrees of each node
        count[currNode] = totalNode;

        return totalNode;
    }

    // DFS method
    private void DFS(Map<Integer, List<Integer>> adj, int parentNode, int prevNode, int[] result) {
        List<Integer> children = adj.get(parentNode);
        if (children != null) {  // Safety check to avoid NullPointerException
            for (int child : children) {
                if (child == prevNode) {
                    continue;
                }

                result[child] = result[parentNode] - count[child] + (N - count[child]);
                DFS(adj, child, parentNode, result);
            }
        }
    }

    // Main method to calculate the sum of distances in a tree
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        N = n;
        count = new int[n];

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            adj.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
            adj.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
        }

        resultBaseNode = 0;

        dfsBase(adj, 0, -1, 0);

        int[] result = new int[n];
        result[0] = (int) resultBaseNode;

        DFS(adj, 0, -1, result);

        return result;
    }
}
