package Graph;

import java.util.*;

public class ShortestBridge {
    private int[][] directions = {
            {-1, 0},
            {0, -1}, {0, 1},
            {1, 0}
    };
    int n;
    int m;
    boolean isSafe(int i,int j){
        if(i>=0&&i<n&&j>=0&&j<m){
            return true;
        }
        return false;
    }
    public void dfs(int [][]grid,int i,int j,Set<Pair<Integer, Integer>> vis){
        if(!isSafe(i,j)||grid[i][j]==0||vis.contains(new Pair<>(i, j))){
            return;
        }
        vis.add(new Pair<>(i, j));
        for (int[] dir : directions) {
            int i_ = i + dir[0];
            int j_ = j + dir[1];

            dfs(grid, i_, j_, vis);
        }
    }
    public int bfs(int [][]grid, Set<Pair<Integer, Integer>> vis){
        Queue<Pair<Integer, Integer>> q = new LinkedList<>();
        for (Pair<Integer, Integer> i : vis) {
            q.offer(i);
        }
        int level = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            while (size-- > 0) {
                Pair<Integer, Integer> P = q.poll();

                for (int[] dir : directions) {
                    int i_ = P.getKey() + dir[0];
                    int j_ = P.getValue() + dir[1];

                    if (isSafe(i_, j_) && !vis.contains(new Pair<>(i_, j_))) {
                        if (grid[i_][j_] == 1)
                            return level;

                        vis.add(new Pair<>(i_, j_));
                        q.offer(new Pair<>(i_, j_));
                    }
                }
            }
            level++;
        }

        return level;
    }
    public int shortestBridge(int[][] grid) {
        m = grid.length;
        n = grid[0].length;

        Set<Pair<Integer, Integer>> vis = new HashSet<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, i, j, vis);
                    return bfs(grid, vis);
                }
            }
        }

        return -1;
    }
    public class Pair<K, V> {
        private final K key;
        private final V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair<?, ?> pair = (Pair<?, ?>) o;
            return Objects.equals(key, pair.key) && Objects.equals(value, pair.value);
        }

        @Override
        public int hashCode() {
            return Objects.hash(key, value);
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }
    }
}
