import java.util.Arrays;

public class NonZeros {
    public static void moveZeroes(int[] nums) {
        int n=nums.length;
        if(n==0||n==1){
            return;
        }
        int zind=0;
        int nzind=0;
        while(nzind<n){
            if(nums[nzind]!=0){
                int temp=nums[nzind];
                nums[nzind]=nums[zind];
                nums[zind]=temp;
                nzind++;
                zind++;
            }
            else{
                nzind++;
            }
        }
    }

    public static void main(String[] args) {
        int arr[]={2,1,0,3,12};
        moveZeroes(arr);
        System.out.println(Arrays.toString(arr));
    }
}
