package SegmentTree;

public class CountofRangeSum {
    public int countRangeSum(int[] nums, int lower, int upper) {
        int n = nums.length;
        long[] prefixSums = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefixSums[i + 1] = prefixSums[i] + nums[i];
        }

        return mergeSortAndCount(prefixSums, 0, n + 1, lower, upper);
    }

    private int mergeSortAndCount(long[] prefixSums, int start, int end, int lower, int upper) {
        if (end - start <= 1) {
            return 0;
        }

        int mid = (start + end) / 2;
        int count = mergeSortAndCount(prefixSums, start, mid, lower, upper) +
                mergeSortAndCount(prefixSums, mid, end, lower, upper);

        int lo = mid, hi = mid;
        for (int i = start; i < mid; i++) {
            while (lo < end && prefixSums[lo] - prefixSums[i] < lower) {
                lo++;
            }
            while (hi < end && prefixSums[hi] - prefixSums[i] <= upper) {
                hi++;
            }
            count += hi - lo;
        }

        merge(prefixSums, start, mid, end);

        return count;
    }

    private void merge(long[] prefixSums, int start, int mid, int end) {
        long[] temp = new long[end - start];
        int i = start, j = mid, k = 0;

        while (i < mid && j < end) {
            if (prefixSums[i] <= prefixSums[j]) {
                temp[k++] = prefixSums[i++];
            } else {
                temp[k++] = prefixSums[j++];
            }
        }

        while (i < mid) {
            temp[k++] = prefixSums[i++];
        }

        while (j < end) {
            temp[k++] = prefixSums[j++];
        }

        System.arraycopy(temp, 0, prefixSums, start, temp.length);
    }
}
