package Arrays;

import java.util.Stack;

public class LargestRectangleinHistogram {
    public static int largestRectangleArea(int[] arr) {
        int res=Integer.MIN_VALUE;
        int n=arr.length;
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<=n;i++){
            int curr=(i==n)?0:arr[i];
            while(!st.isEmpty()&&arr[st.peek()]>curr){
                int h=arr[st.pop()];
                int s=st.isEmpty()?-1:st.peek();
                int w=i-s-1;
                int height=h*w;
                res=Math.max(height,res);
            }
            st.push(i);
        }
        return (res==Integer.MIN_VALUE)?0:res;
    }

    public static void main(String[] args) {
        int arr[]={2,1,5,6,2,3};
        System.out.println(largestRectangleArea(arr));
    }
}
