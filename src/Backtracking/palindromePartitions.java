package Backtracking;

import java.util.ArrayList;

public class palindromePartitions {
    static ArrayList<ArrayList<String>> allPalindromicPerms(String S) {
        ArrayList<ArrayList<String>> res = new ArrayList<>();
        ArrayList<String> path = new ArrayList<>();
        helper(S, 0, path, res);
        return res;
    }

    public static void helper(String S, int ind, ArrayList<String> path, ArrayList<ArrayList<String>> res) {
        if (ind == S.length()) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = ind; i < S.length(); i++) {
            if (isPalindrom(S, ind, i)) {
                path.add(S.substring(ind, i + 1));
                helper(S, i + 1, path, res);
                path.remove(path.size() - 1);
            }
        }
    }

    public static boolean isPalindrom(String S, int start, int end) {
        while (start < end) {
            if (S.charAt(start) != S.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        String s ="aab";
        System.out.println(allPalindromicPerms(s));
    }

}
