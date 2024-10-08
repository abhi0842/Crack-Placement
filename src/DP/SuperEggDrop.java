package DP;
import java.util.*;
public class SuperEggDrop {
    public static int [][] t;
    public int superEggDrop(int k, int n) {
        t=new int[k+1][n+1];
        for(int [] i:t) Arrays.fill(i,-1);
        return helper(k,n);
    }

    public static int helper(int e,int f){
        if(f==0 || f==1 || e==1) return f;
        if(t[e][f]!=-1) return t[e][f];
        int ans=Integer.MAX_VALUE,l=1,h=f;
        while(l<=h){
            int mid=(h+l)/2;
            int left=helper(e-1,mid-1);
            int right=helper(e,f-mid);
            int temp=1+Math.max(left,right);
            if(left<right) l=mid+1;
            else h=mid-1;
            ans=Math.min(ans,temp);
        }
        return t[e][f]=ans;
    }
}
