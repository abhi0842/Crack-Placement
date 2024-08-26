package DP;

public class MinimumInsertionStepsPalindrome {
    public static int minInsertions(String s) {
        int n = s.length();


        int[][] dp = new int[n + 1][n + 1];


        String sRev = new StringBuilder(s).reverse().toString();

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == sRev.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }


        int lps = dp[n][n];

        return n - lps;
    }

    public static void main(String[] args) {
        String s="zzazz";
        System.out.println(minInsertions(s));
    }
}
