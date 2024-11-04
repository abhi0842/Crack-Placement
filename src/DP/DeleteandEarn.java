package DP;

import java.util.HashMap;
import java.util.Map;

public class DeleteandEarn {
    public int deleteAndEarn(int[] nums) {
        if (nums.length == 0) return 0;
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        int maxNum = 0;
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
            maxNum = Math.max(maxNum, num);
        }
        int[] dp = new int[maxNum + 1];
        dp[1] = frequencyMap.getOrDefault(1, 0);
        for (int i = 2; i <= maxNum; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + i * frequencyMap.getOrDefault(i, 0));
        }
        return dp[maxNum];
    }
}

