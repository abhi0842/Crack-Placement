package Greedy;

import java.util.*;

public class NonOverlapingIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n=intervals.length;
        if (intervals.length == 0) {
            return 0;

        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[1], b[1]);
            }
        });

        int count = 0;
        int lastEnd = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < lastEnd) {
                count++;

            } else{ lastEnd=intervals[i][1];}

        }
        return count;
    }
}
