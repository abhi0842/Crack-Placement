import java.util.Arrays;

public class Sortcolors {
    /*                              Brute Force Approach                                    */
     public static void sort(int arr[]){
         for(int i=0;i<arr.length;i++){
             for(int j=i+1;j<arr.length;j++){
                 if(arr[i]>arr[j]){
                     int temp=arr[i];
                     arr[i]=arr[j];
                     arr[j]=temp;
                 }
             }
         }
     }
    /*                              Optimized Approach                                  */
   public static void sortcolors(int nums[]){
         if(nums.length<2){
             return;
         }
         int i=0;
         int start=0;
         int end=nums.length-1;
         while(i<=end&&start<end){
             if(nums[i]==0){
                 nums[i]=nums[start];
                 nums[start]=0;
                 start++;
                 i++;
             }
             else if(nums[i]==2){
                 nums[i]=nums[end];
                 nums[end]=2;
                 end--;
             }
             else{
                 i++;
             }
         }
   }
    public static void main(String[] args) {
        int arr[]={2,0,2,1,1,0};
        sortcolors(arr);
        System.out.println(Arrays.toString(arr));
    }
}
