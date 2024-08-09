package Matrix2D;

import java.util.Arrays;

public class ArrayPuzzle {
    public static long[] productExceptSelf(int nums[]) {
        int n = nums.length;
        long[] result = new long[n];
        long pro = 1;
        for (int i = 0; i < n; i++) {
            result[i] = pro;
            pro *= nums[i];
        }
        pro = 1;
        for (int i = n - 1; i >= 0; i--) {
            result[i] *= pro;
            pro *= nums[i];
        }

        return result;
    }

    public static void main(String[] args) {
        int arr[]={10, 3, 5, 6, 2};
        System.out.println(Arrays.toString(productExceptSelf(arr)));
    }
}
