package Strings;

public class DistinctSubsequences {
    public static int helper(int i,int j,String s,String t,int [][]dp){
        if(j<0){
            return 1;
        }
        if(i<0){
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int res;
        if(s.charAt(i)==t.charAt(j)){
            res= helper(i-1,j-1,s,t,dp)+helper(i-1,j,s,t,dp);
        }
        else{
            res= helper(i-1,j,s,t,dp);
        }
        dp[i][j]=res;
        return res;
    }
    public static int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
       String s = "rabbbit", t = "rabbit";
        System.out.println(numDistinct(s,t));
    }
}
