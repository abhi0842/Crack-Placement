package SearchingSorting;

import java.util.HashSet;
import java.util.Spliterator;

public class FindGivenPair {
    public static int findPair(int n, int x, int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : arr) {
            if (set.contains(num + x) || set.contains(num - x)) {
                return 1;
            }
            set.add(num);
        }
        return -1;
    }

    public static void main(String[] args) {
        int n = 6;
        int x = 78;
        int arr[] = {5, 20, 3, 2, 5, 80};
        System.out.println(findPair(n,x,arr));
    }
}
