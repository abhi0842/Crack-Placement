public class TrappingRainWater {
    public static int trap(int[] height) {
        if(height.length==1||height.length==2){
            return 0;
        }
        int water=0;
        for(int i=1;i<=height.length-2;i++){
            int lb=height[i];
            for(int j=0;j<i;j++){
                lb=Math.max(lb,height[j]);
            }
            int rb=height[i];
            for(int k=i;k<height.length;k++){
                rb=Math.max(rb,height[k]);
            }
            water+=Math.min(lb,rb)-height[i];
        }
        return water;

    }

    public static void main(String[] args) {
        int [] arr={0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(arr));
    }
}
