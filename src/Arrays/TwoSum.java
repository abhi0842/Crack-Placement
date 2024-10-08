package Arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]+nums[j]==target){
                    return new int[]{i,j};
                }
            }
        }
        return null;
    }
    /*                               Optimized Approach                          */
    public static int[] TwoSum(int[] nums, int target) {
        Map<Integer,Integer> res=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int sub=target-nums[i];
            if(res.containsKey(sub)){
                return new int[]{res.get(sub),i};
            }
            res.put(nums[i],i);
        }
        return null;
    }
    public static void main(String[] args) {
        int arr[]=new int[2];
        int nums[]={2,7,11,15};
        int target=9;
        System.out.println(Arrays.toString(TwoSum(nums,target)));
    }
}
