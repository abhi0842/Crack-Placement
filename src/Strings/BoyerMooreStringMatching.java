package Strings;
import java.util.*;
public class BoyerMooreStringMatching {
    private static int[] badCharHeuristic(String pattern) {
        int[] badChar = new int[256];
        Arrays.fill(badChar, -1);
        for (int i = 0; i < pattern.length(); i++) {
            badChar[(int) pattern.charAt(i)] = i;
        }

        return badChar;
    }
    public static void search(String text, String pattern) {
        int m = pattern.length();
        int n = text.length();

        int[] badChar = badCharHeuristic(pattern);

        int s = 0;
        while (s <= n - m) {
            int j = m - 1;
            while (j >= 0 && pattern.charAt(j) == text.charAt(s + j)) {
                j--;
            }
            if (j < 0) {
                System.out.println("Pattern found at index " + s);
                s += (s + m < n) ? m - badChar[text.charAt(s + m)] : 1;
            } else {
                s += Math.max(1, j - badChar[text.charAt(s + j)]);
            }
            }
    }

    public static void main(String[] args) {
        String text = "ABAAABCD";
        String pattern = "ABC";
        search(text,pattern);
    }}
