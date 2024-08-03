package DP;

public class MaximumProductSubarray {
    public static int maxProduct(int[] nums) {
        int n=nums.length;
        long res=nums[0];
        long leftsum=1;
        long rightsum=1;
        for(int i=0;i<n;i++){
            leftsum = (leftsum == 0 || leftsum < Integer.MIN_VALUE) ? 1 : leftsum;
            rightsum = (rightsum == 0 || rightsum < Integer.MIN_VALUE) ? 1 : rightsum;
            leftsum*=nums[i];
            rightsum*=nums[n-1-i];
            res=Math.max(res,Math.max(leftsum,rightsum));
        }
        return (int)res;

    }

    public static void main(String[] args) {
        int arr[]={2,3,-2,4};
        System.out.println(maxProduct(arr));
    }
}
