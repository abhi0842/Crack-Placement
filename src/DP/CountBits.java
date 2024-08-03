package DP;

public class CountBits {
    public static int[] countBits(int n) {
        int result[]=new int[n+1];
        for(int i=0;i<=n;i++){
            int bit =0;
            int num=i;

            while(num!=0){
                bit+=num%2;
                num=num/2;
            }
            result[i]=bit;
        }
        return result;
    }

    public static void main(String[] args) {
        int n=5;
        System.out.println(countBits(n));
    }
}
