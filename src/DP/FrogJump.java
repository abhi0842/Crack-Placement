package DP;

import java.util.HashMap;
import java.util.HashSet;

public class FrogJump {
    public boolean canCross(int[] stones) {
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
        for (int stone : stones) {
            map.put(stone, new HashSet<>());
        }

        map.get(stones[0]).add(1);

        for (int i = 0; i < stones.length; i++) {
            int stone = stones[i];
            for (int jump : map.get(stone)) {
                int reach = stone + jump;
                if (reach == stones[stones.length - 1]) {
                    return true;
                }

                if (map.containsKey(reach)) {
                    if (jump - 1 > 0) map.get(reach).add(jump - 1);
                    map.get(reach).add(jump);
                    map.get(reach).add(jump + 1);
                }
            }
        }

        return false;
    }
}
