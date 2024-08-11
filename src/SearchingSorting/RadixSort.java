package SearchingSorting;

import java.util.Arrays;

public class RadixSort {
    public static void redix(int arr[]){
        int max= Arrays.stream(arr).max().getAsInt();
        for(int exp=1;max/exp>0;exp*=10){
         countsort(arr,exp);
        }
    }

    private static void countsort(int[] arr, int exp) {
        int n=arr.length;
        int out[]=new int[n];
        int count[]=new int[10];
        Arrays.fill(count,0);
        for(int i=0;i<n;i++){
            count[(arr[i]/exp)%10]++;
        }
        for(int i=1;i<10;i++){
            count[i]=count[i]+count[i-1];
        }
        for(int i=n-1;i>=0;i--){
            out[count[(arr[i]/exp)%10]-1]=arr[i];
            count[(arr[i]/exp)%10]--;
        }
        System.arraycopy(out,0,arr,0,n);
    }

    public static void main(String[] args) {
        int arr[]={29,83,471,36,91,8};
        System.out.println(Arrays.toString(arr));
        redix(arr);
        System.out.println(Arrays.toString(arr));
    }
}
