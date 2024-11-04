package Strings;

import java.util.Stack;

public class RemoveAllAdjacentDuplicatesinStringII {
    public static String removeDuplicates(String s, int k) {
        Stack<int[]> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek()[0] == c) {
                stack.peek()[1]++;
                if (stack.peek()[1] == k) {
                    stack.pop();
                }
            } else {
                stack.push(new int[]{c, 1});
            }
        }
        StringBuilder result = new StringBuilder();
        for (int[] entry : stack) {
            result.append(String.valueOf((char)entry[0]).repeat(entry[1]));
        }

        return result.toString();
    }

}
