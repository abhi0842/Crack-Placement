public class jumpgame {
    public static boolean canJump(int[] nums) {
        int n=nums.length;
        boolean dp[]=new boolean[n];
        dp[0]=true;
        for(int i=1;i<n;i++){
            for(int j=i-1;j>=0;j--){
                if(dp[j]==true&&j+nums[j]>=i){
                    dp[i]= true;
                    break;
                }
            }
        }
        return dp[n-1];
    }

    public static void main(String[] args) {
        int arr[]={3,2,1,0,4};
        System.out.println(canJump(arr));
    }
}
