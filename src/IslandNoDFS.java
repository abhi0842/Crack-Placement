public class IslandNoDFS {
    public static int numIslands(char[][] grid) {
        int ans = 0;
        int n = grid.length;
        int m = grid[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    ans++;
                    island(grid, i, j, n, m);
                }
            }
        }
        return ans;
    }

    public static void island(char grid[][], int i, int j, int n, int m) {
        grid[i][j] = '0';
        if (isvalid(grid, i, j + 1, n, m)) {
            island(grid, i, j + 1, n, m);
        }
        if (isvalid(grid, i, j - 1, n, m)) {
            island(grid, i, j - 1, n, m);
        }
        if (isvalid(grid, i - 1, j, n, m)) {
            island(grid, i - 1, j, n, m);
        }
        if (isvalid(grid, i + 1, j, n, m)) {
            island(grid, i + 1, j, n, m);
        }
    }

    public static boolean isvalid(char[][] grid, int i, int j, int n, int m) {
        if (i >= 0 && j >= 0 && i < n && j < m && grid[i][j] == '1') {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        char[][] arr = {{'1', '1', '1', '1', '0'},
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        System.out.println(numIslands(arr));
    }
}