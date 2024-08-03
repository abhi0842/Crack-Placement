package Heap;

import org.w3c.dom.ls.LSOutput;

public class kthElementinsorted {
    private static int counthelper(int[][] matrix, int val) {
        int n = matrix.length;
        int count = 0;
        int row = n - 1;
        int col = 0;

        while (row >= 0 && col < n) {
            if (matrix[row][col] <= val) {
                count += (row + 1);
                col++;
            } else {
                row--;
            }
        }

        return count;
    }
    public static int kthSmallest(int[][] matrix, int k) {
        int n=matrix.length;
        int l=matrix[0][0];
        int r=matrix[n-1][n-1];

        while(l<r){
            int mid=l+(r-l)/2;
            int  count=counthelper( matrix,mid);
            if(count<k){
                l=mid+1;
            }
            else{
                r=mid;
            }
        }
        return l;

    }

    public static void main(String[] args) {
        int arr[][]={{1,5,9},{10,11,13},{12,13,15}};
        int k=8;
        System.out.println(kthSmallest(arr,k));
    }
}
