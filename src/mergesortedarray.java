import java.util.Arrays;

public class mergesortedarray {
    public static void merge(int[] left, int m, int[] right, int n) {

        int i=m-1;
        int j=n-1;
        int k=m+n-1;
        while(j>=0){
            if(i>=0&&left[i]>right[j]){
                left[k]=left[i];
                k--;
                i--;
            }
            else{
                left[k]=right[j];
                j--;
                k--;
            }
        }
    }

    public static void main(String[] args) {
        int left[]={1,2,3,0,0,0};
        int right[]={2,5,6};
        int m=3;
        int n=3;
        merge(left,m,right,n);
        System.out.println(Arrays.toString(left));

    }
}
