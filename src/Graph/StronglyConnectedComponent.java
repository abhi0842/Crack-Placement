package Graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.*;

public class StronglyConnectedComponent {
         static void topsort(int curr, ArrayList<ArrayList<Integer>> adj, boolean[] visited, Stack<Integer> stack) {
        visited[curr] = true;

        for (int neighbor : adj.get(curr)) {
            if (!visited[neighbor]) {
                topsort(neighbor, adj, visited, stack);
            }
        }

        stack.push(curr);
    }
     static void dfsOnTranspose(int v, ArrayList<ArrayList<Integer>> transposeAdj, boolean[] visited) {
        visited[v] = true;

        for (int neighbor : transposeAdj.get(v)) {
            if (!visited[neighbor]) {
                dfsOnTranspose(neighbor, transposeAdj, visited);
            }
        }
    }
        private static ArrayList<ArrayList<Integer>> getTranspose(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<ArrayList<Integer>> transposeAdj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            transposeAdj.add(new ArrayList<>());
        }

        for (int i = 0; i < V; i++) {
            for (int neighbor : adj.get(i)) {
                transposeAdj.get(neighbor).add(i);
            }
        }

        return transposeAdj;
    }
        public static int kosaraju(int V, ArrayList<ArrayList<Integer>> adj) {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                topsort(i, adj, visited, stack);
            }
        }
        ArrayList<ArrayList<Integer>> transposeAdj = getTranspose(V, adj);
        Arrays.fill(visited, false);
        int sccCount = 0;
        while (!stack.isEmpty()) {
            int v = stack.pop();

            if (!visited[v]) {
                dfsOnTranspose(v, transposeAdj, visited);
                sccCount++;
            }
        }

        return sccCount;
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


            int numSCCs = kosaraju(V, adj);
            System.out.println(numSCCs);
        }
    }


