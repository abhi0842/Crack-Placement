package DP;

public class countPalindromicsubsequence {
    private static final int MOD = 1000000007;
    private int[][] memo;

    public int countPalindromicSubsequences(String s) {
        int n = s.length();
        memo = new int[n][n];
        return countPalindromicSubsequences(s, 0, n - 1);
    }

    private int countPalindromicSubsequences(String s, int start, int end) {
        if (start > end) {
            return 0;
        }
        if (start == end) {
            return 1;
        }
        if (memo[start][end] != 0) {
            return memo[start][end];
        }

        long result;
        if (s.charAt(start) == s.charAt(end)) {
            int left = start + 1;
            int right = end - 1;

            while (left <= right && s.charAt(left) != s.charAt(start)) left++;
            while (left <= right && s.charAt(right) != s.charAt(end)) right--;

            if (left > right) {
                // No same characters inside
                result = countPalindromicSubsequences(s, start + 1, end - 1) * 2 + 2;
            } else if (left == right) {
                // Only one same character inside
                result = countPalindromicSubsequences(s, start + 1, end - 1) * 2 + 1;
            } else {
                // Multiple same characters inside
                result = countPalindromicSubsequences(s, start + 1, end - 1) * 2
                        - countPalindromicSubsequences(s, left + 1, right - 1);
            }
        } else {
            result = countPalindromicSubsequences(s, start + 1, end)
                    + countPalindromicSubsequences(s, start, end - 1)
                    - countPalindromicSubsequences(s, start + 1, end - 1);
        }

        result = (result + MOD) % MOD;
        memo[start][end] = (int) result;
        return memo[start][end];
    }
}
