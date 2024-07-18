import java.util.Arrays;

public class FindtheDuplicateNumber {
    /*                              Brute Force Approach                                    */
    public static int findduplicate(int arr[]){
        Arrays.sort(arr);
        for(int i=0;i<arr.length;i++){
            if(arr[i]==arr[i+1]){
                return arr[i];
            }
        }
        return 0;
    }
    /*                               Optimized Approach using cyclic sort                           */
 public static int findduplicatecycle(int arr[]){
     int i=0;
     while(i<arr.length){
         if(arr[i]!=i+1){
             int curr=arr[i]-1;
             if(arr[i]!=arr[curr]){
                 int temp=arr[i];
                 arr[i]=arr[curr];
                 arr[curr]=temp;
             }
             else{
                 return arr[i];
             }
         }
         else{
             i++;
         }
     }
     return -1;

 }
    public static void main(String[] args) {
        int arr[]={3,1,3,4,2};
        System.out.println(findduplicatecycle(arr));
    }
}
