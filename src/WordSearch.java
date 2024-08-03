public class WordSearch
{
    public static boolean helper(char[][] board, String word,int i,int j,int m,int n,int k){
        if(k==word.length()){
            return true;
        }
        if(i<0||j<0||i==m||j==n||board[i][j]!=word.charAt(k)){
            return false;
        }
        char temp=board[i][j];
        board[i][j]='#';
        boolean left=helper(board,word,i,j-1,m,n,k+1);
        boolean right=helper(board,word,i,j+1,m,n,k+1);
        boolean up=helper(board,word,i-1,j,m,n,k+1);
        boolean down=helper(board,word,i+1,j,m,n,k+1);
        board[i][j]=temp;
        return left||right||up||down;
    }
    public static boolean exist(char[][] board, String word) {
        int m=board.length;
        int n=board[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]==word.charAt(0)){
                    if(helper(board,word,i,j,m,n,0)){
                        return true;
                    }
                }
            }

        }
        return false;
    }

    public static void main(String[] args) {
        char arr[][]={{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word="ABCCED";
        System.out.println(exist(arr,word));
    }
}
