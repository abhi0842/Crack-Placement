package Arrays;

import java.util.HashMap;

public class Subarraysumk {
    public static  int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,1);
        int ans=0;
        int sum=0;
        int count=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            int val=sum-k;
            count=count+map.getOrDefault(val,0);
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return count;
    }

    public static void main(String[] args) {
        int arr[]={1,1,1};
        int k=2;
        System.out.println(subarraySum(arr,k));
    }
}
