package DP;
import java.util.*;
public class DecodeWays {
    public int numDecodings(String s) {
        int[] memo = new int[s.length()];
        Arrays.fill(memo, -1);
        return topDownDecode(s, 0, memo);
    }

    private int topDownDecode(String s, int index, int[] memo) {
        if (index == s.length()) {
            return 1;
        }
        if (memo[index] != -1) {
            return memo[index];
        }
        if (s.charAt(index) == '0') {
            return 0;
        }
        int ways = topDownDecode(s, index + 1, memo);
        if (index + 1 < s.length() && Integer.parseInt(s.substring(index, index + 2)) <= 26) {
            ways += topDownDecode(s, index + 2, memo);
        }
        memo[index] = ways;

        return ways;
    }
}
