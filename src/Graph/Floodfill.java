package Graph;

import java.util.Arrays;

public class Floodfill {
    public static void fill(int[][] image,int i,int j,int color,int newcolor){
        if (i < 0 || i >= image.length || j < 0 || j >= image[0].length || image[i][j] == newcolor || image[i][j] != color) {
            return;
        }
        image[i][j]=newcolor;
        fill(image, i - 1, j, color, newcolor);
        fill(image, i + 1, j, color, newcolor);
        fill(image, i, j - 1, color, newcolor);
        fill(image, i, j + 1, color, newcolor);

    }
    public static int[][] floodFill(int[][] image, int sr, int sc, int newcolor) {

        int color=image[sr][sc];
        fill(image,sr,sc,color,newcolor);
        return image;
    }

    public static void main(String[] args) {
        int arr[][]={{2,2,2},{2,2,0},{2,0,1}};
        int sc=1;int sr=1;
        int color=3;
        System.out.println(Arrays.deepToString(floodFill(arr,sr,sc,color)));
    }
}
