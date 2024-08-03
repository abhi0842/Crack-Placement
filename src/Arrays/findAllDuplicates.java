package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class findAllDuplicates {
    public static List<Integer> findDuplicates(int[] arr) {
        int i=0;
        List<Integer> res=new ArrayList<>();
        while(i<arr.length){
            int curr=arr[i]-1;
            if(arr[i]!=arr[curr]){
                int temp=arr[i];
                arr[i]=arr[curr];
                arr[curr]=temp;
            }

            else{
                i++;
            }}
        for(int j=0;j<arr.length;j++){
            if(arr[j]!=j+1){
                res.add(arr[j]);
            }
        }

        return res;

    }

    public static void main(String[] args) {
        int arr[]={4,3,2,7,8,2,3,1};
        System.out.println(findDuplicates(arr));
    }
}
