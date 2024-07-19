import java.util.Arrays;

public class ContainerWithMostWater {
    public static int maxArea(int[] height) {
        int i=0;
        int j=height.length-1;
        int maxsum=0;

        while(i<j){
            int h=Math.min(height[j],height[i]);
            int w=j-i;
            int sum = h*w;
            if(height[j]>height[i]){
                i++;
            }
            else{
                j--;
            }
            maxsum= Math.max(sum,maxsum);
        }

        return maxsum;
    }

    public static void main(String[] args) {
        int arr[]={1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(arr));

    }
}
