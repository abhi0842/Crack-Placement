package Arrays;

import java.util.Arrays;

public class SetMatrixZeros {

    public static void setZeroes(int[][] arr) {
        int n=arr.length;
        int m=arr[0].length;
        boolean row[]=new boolean[n];
        boolean col[]=new boolean[m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(arr[i][j]==0){
                    row[i]=true;
                    col[j]=true;
                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(row[i]==true||col[j]==true){
                    arr[i][j]=0;
                }
            }
        }
    }

    public static void set(int arr[][]){

    }
    public static void main(String[] args) {
        int arr[][]={{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        setZeroes(arr);
        System.out.println(Arrays.deepToString(arr));
    }
}
