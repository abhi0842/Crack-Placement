package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class FourSum {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        HashSet<String> uni=new HashSet<>();
        int n = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < n - 3; i++) {
            for (int j = i + 1; j < n - 2; j++) {
                int left=j+1;
                int right=n-1;
                while(left<right){
                    long sum=nums[i];
                    sum+=nums[j];
                    sum+=nums[left];
                    sum+=nums[right];
                    if(sum<target){
                        left++;
                    }
                    else if(sum>target){
                        right--;
                    }
                    else{
                        StringBuilder sb=new StringBuilder();
                        sb.append(nums[i]);
                        sb.append(nums[j]);
                        sb.append(nums[left]);
                        sb.append(nums[right]);
                        String c=sb.toString();
                        if(uni.contains(c)==false){
                            uni.add(c);
                            ans.add(Arrays.asList(nums[i],nums[j],nums[left],nums[right]));
                        }

                        left++;
                        right--;
                    }
                }
            }
        }

        return ans;

    }

    public static void main(String[] args) {
        int arr[]={1,0,-1,0,-2,2};
        int target=0;
        System.out.println(fourSum(arr,target));
    }
}
