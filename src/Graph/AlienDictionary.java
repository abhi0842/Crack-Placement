package Graph;

import java.util.*;

public class AlienDictionary {
    public String findOrder(String[] words, int N, int K) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            graph.add(new ArrayList<>());
        }
        int[] inDegree = new int[K];
        for (int i = 0; i < N - 1; i++) {
            String word1 = words[i];
            String word2 = words[i + 1];
            int minLength = Math.min(word1.length(), word2.length());
            for (int j = 0; j < minLength; j++) {
                if (word1.charAt(j) != word2.charAt(j)) {
                    int u = word1.charAt(j) - 'a';
                    int v = word2.charAt(j) - 'a';
                    if (!graph.get(u).contains(v)) {
                        graph.get(u).add(v);
                        inDegree[v]++;
                    }
                    break;
                }
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        StringBuilder order = new StringBuilder();
        for (int i = 0; i < K; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int node = queue.poll();
            order.append((char) (node + 'a'));

            for (int neighbor : graph.get(node)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }
        if (order.length() == K) {
            return order.toString();
        } else {
            return ""; }
    }
}
