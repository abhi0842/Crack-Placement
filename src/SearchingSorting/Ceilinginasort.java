package SearchingSorting;

public class Ceilinginasort {
    static int ceilSearch(int arr[],  int x) {
        int low=0;
        int high=arr.length;
        int i;
        if(x <= arr[low])
            return low;
        for(i = low; i < high; i++)
        {
            if(arr[i] == x)
                return i;
            if(arr[i] < x && arr[i+1] >= x)
                return i+1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int arr[]={0, 1, 8, 10, 11, 12, 20};
        int x = 3;
        System.out.println(ceilSearch(arr,x));
    }
}
