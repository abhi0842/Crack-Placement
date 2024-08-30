package DP;

public class PartitionEqualSubsetSum {
    static String equalPartition(int N, int arr[])
    {
        int n=N;
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        if (sum % 2 != 0) {
            return "NO";
        }

        int target = sum / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        for (int num : arr) {
            for (int i = target; i >= num; i--) {
                dp[i] = dp[i] || dp[i - num];
            }
        }
        return dp[target] ? "YES" : "NO";
    }

    public static void main(String[] args) {
       int N = 4;
       int []arr ={1, 5, 11, 5};
        System.out.println(equalPartition(N,arr));
    }
}
