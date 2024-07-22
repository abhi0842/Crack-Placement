public class MaximumCardPoints {
    public static int maxScore(int[] cardPoints, int k) {
        int n=cardPoints.length;
        if (n < k) {

            return -1;
        }


        int max_sum = 0;
        for (int i = 0; i < k; i++)
            max_sum += cardPoints[i];


        int window_sum = max_sum;
        for (int i = k-1; i >=0; i--) {
            window_sum -=cardPoints[i];
            window_sum += cardPoints[cardPoints.length+i - k];
            max_sum = Math.max(max_sum, window_sum);
        }

        return max_sum;
    }

    public static void main(String[] args) {
        int arr[]={1,2,3,4,5,6,1};
        int k=3;
        System.out.println(maxScore(arr,k));
    }

}
