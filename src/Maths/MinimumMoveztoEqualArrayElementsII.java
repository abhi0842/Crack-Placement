package Maths;
import java.util.*;
public class MinimumMoveztoEqualArrayElementsII {
    public static int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int i=0;
        int j=nums.length-1;
        int count=0;
        while(i<j){
            count+=nums[j]-nums[i];
            i++;
            j--;
        }
        return count;
    }

    public static void main(String[] args) {
        int arr[]={1,2,3};
        System.out.println(minMoves2(arr));
    }

}
