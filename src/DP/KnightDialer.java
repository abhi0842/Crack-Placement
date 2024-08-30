package DP;
import java.util.*;
public class KnightDialer {
    private static final int M = 1000000007;
    private static final List<List<Integer>> adj = Arrays.asList(
            Arrays.asList(4, 6),
            Arrays.asList(6, 8),
            Arrays.asList(7, 9),
            Arrays.asList(4, 8),
            Arrays.asList(3, 9, 0),
            Arrays.asList(),
            Arrays.asList(1, 7, 0),
            Arrays.asList(2, 6),
            Arrays.asList(1, 3),
            Arrays.asList(2, 4)
    );
    int[][] dp = new int[5001][10];
    public int knightDialer(int n) {
        int result = 0;
        Arrays.stream(dp).forEach(row -> Arrays.fill(row, -1));

        for (int cell = 0; cell <= 9; cell++) {
            result = (result + solve(n - 1, cell)) % M;
        }

        return result;

    }
    public int solve(int n,int cell){
        if(n==0){
            return 1;
        }
        if(dp[n][cell]!=-1){
            return dp[n][cell];
        }
        int result=0;
        for(int nextCell : adj.get(cell)){
            result=(result+solve(n-1,nextCell))%M;
        }
        return dp[n][cell]=result;

    }
}
