package DP;

public class UniquePaths {
    public static int helper(int i,int j,int m,int n,int dp[][]){
        if(i==m-1&&j==n-1){
            return 1;
        }
        if(i<0||i>=m||j<0||j>=n){
            return 0;
        }
        if(dp[i][j]!=0){
            return dp[i][j];
        }
        int right=helper(i,j+1,m,n,dp);
        int down=helper(i+1,j,m,n,dp);
        return dp[i][j]=right+down;
    }
    public static int uniquePaths(int m, int n) {
        int dp[][]=new int [m][n];
        return helper(0,0,m,n,dp);
    }

    public static void main(String[] args) {
        int m=3;int n=7;
        System.out.println(uniquePaths(m,n));
    }
}
