package Greedy;

import java.util.Stack;

public class FindtheMostCompetitiveSubsequence {
    public int[] mostCompetitive(int[] nums, int k) {
        Stack<Integer> stack = new Stack<>();
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && nums[i] < stack.peek() && stack.size() + (n - i - 1) >= k) {
                stack.pop();
            }
            if (stack.size() < k) {
                stack.push(nums[i]);
            }
        }
        int[] result = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }

        return result;
    }
}
