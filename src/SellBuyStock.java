public class SellBuyStock {
    public static int maxProfit(int[] arr) {
        int n=arr.length;

        int profit=0;
        for(int i=1;i<n;i++){
            if(arr[i]>=arr[i-1]){
                profit+=arr[i]-arr[i-1];
            }


        }

        return profit;
    }

    public static void main(String[] args) {
        int arr[]={7,1,5,3,6,4};
        System.out.println(maxProfit(arr));
    }
}
