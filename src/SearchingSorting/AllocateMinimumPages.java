package SearchingSorting;

public class AllocateMinimumPages {
    public static long findPages(int n, int[] arr, int m) {
        if(m>n){
            return -1;
        }

        long ans=0;
        int sum=0;
        int max=0;

        for(int i=0;i<n;i++){
            sum+=arr[i];
            max=Math.max(max,arr[i]);
        }
        if(m==n){
            return max;
        }
        int low=max;
        int hi=sum;
        while(low<=hi){
            int mid=low+(hi-low)/2;
            if(isPossible(arr,mid,m)){
                ans=mid;
                hi=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return ans;
    }
    public static boolean isPossible(int arr[],int mid,int m){
        int st=1;
        int sum=0;
        for(int i=0;i<arr.length;i++){
            if (sum + arr[i] > mid) {
                st++;
                sum = arr[i];
                if (st > m) {
                    return false;
                }
            } else {
                sum += arr[i];
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int arr[]={12, 34, 67, 90};
      long ans=  findPages(4,arr,2);
        System.out.println(ans);
    }
}
