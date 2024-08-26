package DP;

public class LongestCommonSubstring {
    public static int longestCommonSubstr(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();


        int[][] dp = new int[n + 1][m + 1];

        int maxLength = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    maxLength = Math.max(maxLength, dp[i][j]);
                } else {
                    dp[i][j] = 0;
                }
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
       String str= "ABCDGH", str2 = "ACDGHR";
      int n= longestCommonSubstr(str,str2);
        System.out.println(n);
    }
}
