import java.util.Arrays;

public class CountSort {
    public static void count(int arr[]){
        if(arr==null||arr.length<=1){
            return ;
        }
        int largest=arr[0];
        for(int i=1;i<arr.length;i++){
            if(largest<arr[i]){
               largest=arr[i];
            }
        }
        int count[]=new int[largest+1];
        for(int i:arr){
            count[i]++;
        }
        int ind=0;
        for(int i=0;i<=largest;i++){
            while(count[i]>0){
                arr[ind]=i;
                ind++;
                count[i]--;
            }
        }
    }

    public static void main(String[] args) {
        int arr[]={5,6,9,2,1,5,4,3,2};
        count(arr);
        System.out.println(Arrays.toString(arr));
    }
}
