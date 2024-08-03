package SearchingSorting;

import java.util.Arrays;

public class PermuteArraysSum {
    public static void reverse(int arr[]){
        int i=0;
        int j=arr.length-1;
        while(i<j){
            int temp=arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
            i++;
            j--;
        }
    }
    public static boolean permute(int arr[],int []nums,int k){
        int n=arr.length;
        Arrays.sort(arr);
        Arrays.sort(nums);
        reverse(nums);
        for(int i=0;i<n;i++){
            if(arr[i]+nums[i]<k){
                return false;
            }
        }
return true;
    }
    public static void main(String[] args) {
        int arr[]={2, 1, 3};
        int nums[]={7, 8, 9};
        int k=5;
        System.out.println(permute(arr,nums,k));
    }
}
