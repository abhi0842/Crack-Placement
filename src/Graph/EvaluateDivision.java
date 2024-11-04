package Graph;

import java.util.*;

public class EvaluateDivision {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> graph = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            String u = equations.get(i).get(0);
            String v = equations.get(i).get(1);
            double value = values[i];

            graph.computeIfAbsent(u, k -> new HashMap<>()).put(v, value);
            graph.computeIfAbsent(v, k -> new HashMap<>()).put(u, 1.0 / value);
        }

        double[] results = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            String u = queries.get(i).get(0);
            String v = queries.get(i).get(1);

            if (!graph.containsKey(u) || !graph.containsKey(v)) {
                results[i] = -1.0;
            } else if (u.equals(v)) {
                results[i] = 1.0;
            } else {
                Set<String> visited = new HashSet<>();
                results[i] = dfs(u, v, graph, visited);
            }
        }

        return results;
    }

    private double dfs(String u, String v, Map<String, Map<String, Double>> graph, Set<String> visited) {
        if (u.equals(v)) {
            return 1.0;
        }

        visited.add(u);

        for (Map.Entry<String, Double> neighbor : graph.get(u).entrySet()) {
            if (!visited.contains(neighbor.getKey())) {
                double result = dfs(neighbor.getKey(), v, graph, visited);
                if (result != -1.0) {
                    return result * neighbor.getValue();
                }
            }
        }

        return -1.0;
    }
}
