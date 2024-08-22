package Greedy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MinimumDeletionsFrequenciesUnique {
    public int minDeletions(String s) {

        Map<Character, Integer> freqMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }

        Set<Integer> frequencies = new HashSet<>();
        int deletions = 0;

        for (int freq : freqMap.values()) {
            while (freq > 0 && !frequencies.add(freq)) {
                freq--;
                deletions++;
            }
        }

        return deletions;
    }
}
