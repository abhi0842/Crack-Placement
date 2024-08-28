package Stack;

public class TheCelebrityProblem {
    public static int celebrity(int mat[][]) {
        int n=mat.length;
        int m=mat[0].length;

        int iknow[]=new int[n];
        int knowme[]=new int[m];

        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                if(mat[i][j]==1){
                    knowme[j]++;
                    iknow[i]++;

                }
            }}
        for(int i=0;i<n-1;i++){
            if(iknow[i]==0&&knowme[i]==n-1){
                return i;
            }
        }

        return -1;
    }
    public static int optcelebrity(int mat[][]) {
        int n = mat.length;
        int i = 0, j = n - 1;
        while (i < j) {
            if (mat[i][j] == 1) {
                i++; // i knows j, so i cannot be a celebrity
            } else {
                j--; // i doesn't know j, so j cannot be a celebrity
            }
        }

        int candidate = i;

        // Step 2: Verify the candidate
        for (int k = 0; k < n; k++) {
            if (k != candidate) {
                if (mat[candidate][k] == 1 || mat[k][candidate] == 0) {
                    return -1;
                }
            }
        }

        return candidate;
    }

    public static void main(String[] args) {
        int arr[][]={{0 ,1},{0, 1}};
        System.out.println(optcelebrity(arr));
    }
}
