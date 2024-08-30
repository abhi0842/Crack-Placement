package SearchingSorting;
import java.util.*;
public class AggressiveCow {
    public static boolean isPossible(int[] stalls, int n, int c, int minDist) {
        int cowCount = 1;
        int lastPlacedCow = stalls[0];

        for (int i = 1; i < n; i++) {
            if (stalls[i] - lastPlacedCow >= minDist) {
                cowCount++;
                lastPlacedCow = stalls[i];
                if (cowCount == c) {
                    return true;
                }
            }
        }
        return false;
    }

    public static int largestMinDistance(int[] stalls, int n, int c) {
        Arrays.sort(stalls);

        int low = 1;
        int high = stalls[n - 1] - stalls[0];
        int ans = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (isPossible(stalls, n, c, mid)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int c = sc.nextInt();

            int[] stalls = new int[n];

            for (int i = 0; i < n; i++) {
                stalls[i] = sc.nextInt();
            }

            System.out.println(largestMinDistance(stalls, n, c));
        }

        sc.close();
    }
}
