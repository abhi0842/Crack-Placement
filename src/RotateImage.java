import java.util.Arrays;

public class RotateImage {
    public void swap(int a, int b) {
        int temp = a;
        a = b;
        b = temp;
    }

    public static void rotate(int[][] nums) {
        int n = nums.length;
        int m = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                int temp = nums[i][j];
                nums[i][j] = nums[j][i];
                nums[j][i] = temp;
            }
        }
        for (int k = 0; k < n; k++) {
            int start = 0;
            int end = n - 1;
            while (start < end) {
                int temp = nums[k][start];
                nums[k][start] = nums[k][end];
                nums[k][end] = temp;
                start++;
                end--;
            }
        }
    }

    public static void main(String[] args) {
        int arr[][] = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        rotate(arr);
        System.out.println(Arrays.deepToString(arr));

    }
}