package DP;
import java.util.*;
public class LongestIncreasingSubsequence {
    public int helper(int ind,int pre,int []arr,int n,int dp[][]){
        if(ind==n){
            return 0;

        }
        if(dp[ind][pre+1]!=-1){
            return dp[ind][pre+1];
        }
        int len=0+helper(ind+1,pre,arr,n,dp);
        if(pre==-1||arr[ind]>arr[pre]){
            len=Math.max(len,1+helper(ind+1,ind,arr,n,dp));
        }
        return dp[ind][pre+1]=len;
    }
    public int lengthOfLIS(int[] nums) {

        int n=nums.length;
        int dp[][] = new int[n][n + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return helper(0,-1,nums,nums.length,dp);
    }
}
