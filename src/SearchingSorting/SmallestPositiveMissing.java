package SearchingSorting;

import java.util.*;

public class SmallestPositiveMissing {
    static int missingNumber(int arr[], int size) {
        System.out.println(Arrays.toString(arr));
        for (int i = 0; i < size; i++) {
            if (arr[i] <= 0) {
                arr[i] = size + 1;
            }
        }
        System.out.println(Arrays.toString(arr));
        for (int i = 0; i < size; i++) {
            int ind = Math.abs(arr[i]) - 1;
            if (ind < size && arr[ind] > 0) {
                arr[ind] = -arr[ind];
            }
        }
        System.out.println(Arrays.toString(arr));
        for (int i = 0; i < size; i++) {
            if (arr[i] > 0) {
                return i + 1;
            }
        }
        System.out.println(Arrays.toString(arr));
        return size + 1;

    }

    public static void main(String[] args) {

    }
}
