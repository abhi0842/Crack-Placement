import java.util.ArrayList;
import java.util.List;

public class spiralmatrix {
    public static List<Integer> spiralOrder(int[][] matrix) {
        int m=matrix.length;
        List<Integer>res=new ArrayList<>();
        if(m==0)
            return res;
        int n=matrix[0].length;

        int rowstart=0;
        int rowend=m;
        int colstart=0;
        int colend=n;

        int k;

        while(rowstart<rowend && colstart<colend)
        {

            for(k=colstart;k<colend;k++)
                res.add(matrix[rowstart][k]);
            rowstart+=1;

            for(k=rowstart;k<rowend;k++)
                res.add(matrix[k][colend-1]);
            colend-=1;

            if(rowstart<rowend)
            {
                for(k=colend-1;k>=colstart;k--)
                    res.add(matrix[rowend-1][k]);
                rowend-=1;
            }

            if(colstart<colend)
            {
                for(k=rowend-1;k>=rowstart;k--)
                    res.add(matrix[k][colstart]);
                colstart+=1;
            }

        }
        return res;
    }

    public static void main(String[] args) {
        int arr[][]={ {1,   2,   3,   4,  5,   6},
                {7,   8,   9,  10,  11,  12},
                {13,  14,  15, 16,  17,  18}};
        System.out.println(spiralOrder(arr));
    }
}
