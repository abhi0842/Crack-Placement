package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class Topologicalsort {
    public static void helpertopsort(ArrayList<ArrayList<Integer>> adj, boolean[] vis, int curr, Stack<Integer> stack) {
        vis[curr] = true;
        for (int neighbour : adj.get(curr)) {
            if (!vis[neighbour]) {
                helpertopsort(adj, vis, neighbour, stack);
            }
        }
        stack.push(curr);
    }
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis = new boolean[V];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                helpertopsort(adj, vis, i, stack);
            }
        }
        int[] res = new int[V];
        int ind = 0;
        while (!stack.isEmpty()) {
            res[ind] = stack.pop();
            ind++;
        }

        return res;
    }

    public static void main(String[] args) {
        int V = 5;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(0).add(2); // 0 → 2
        adj.get(2).add(1); // 2 → 1
        adj.get(1).add(0); // 1 → 0
        adj.get(0).add(3); // 0 → 3
        adj.get(3).add(4); // 3 → 4


        int numSCCs []= topoSort(V,adj);
        System.out.println(Arrays.toString(numSCCs));
    }
}
