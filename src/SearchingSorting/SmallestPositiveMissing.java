package SearchingSorting;

public class SmallestPositiveMissing {
    static int missingNumber(int arr[], int size) {
        for (int i = 0; i < size; i++) {
            if (arr[i] <= 0) {
                arr[i] = size + 1;
            }
        }
        for (int i = 0; i < size; i++) {
            int ind = Math.abs(arr[i]) - 1;
            if (ind < size && arr[ind] > 0) {
                arr[ind] = -arr[ind];
            }
        }
        for (int i = 0; i < size; i++) {
            if (arr[i] > 0) {
                return i + 1;
            }
        }
        return size + 1;
    }

    public static void main(String[] args) {
        int arr[]={0,-10,1,3,-20};
        int n=5;
        System.out.println(missingNumber(arr,n));
    }
}
