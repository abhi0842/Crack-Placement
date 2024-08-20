package SearchingSorting;

import java.util.*;

public class CountofSmallerNumbersAfterSelf {
    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        Integer[] result = new Integer[n];
        Arrays.fill(result, 0);

        int[] indices = new int[n];
        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }

        mergeSort(nums, indices, 0, n - 1, result);

        return Arrays.asList(result);
    }

    private void mergeSort(int[] nums, int[] indices, int left, int right, Integer[] result) {
        if (left >= right) return;

        int mid = left + (right - left) / 2;
        mergeSort(nums, indices, left, mid, result);
        mergeSort(nums, indices, mid + 1, right, result);
        merge(nums, indices, left, mid, right, result);
    }

    private void merge(int[] nums, int[] indices, int left, int mid, int right, Integer[] result) {
        int[] temp = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;
        int rightCount = 0;

        while (i <= mid && j <= right) {
            if (nums[indices[j]] < nums[indices[i]]) {
                temp[k++] = indices[j++];
                rightCount++;
            } else {
                result[indices[i]] += rightCount;
                temp[k++] = indices[i++];
            }
        }

        while (i <= mid) {
            result[indices[i]] += rightCount;
            temp[k++] = indices[i++];
        }

        while (j <= right) {
            temp[k++] = indices[j++];
        }

        for (int p = 0; p < temp.length; p++) {
            indices[left + p] = temp[p];
        }
    }
}
