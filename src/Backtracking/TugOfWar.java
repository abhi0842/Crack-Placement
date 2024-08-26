package Backtracking;

import java.util.ArrayList;

public class TugOfWar {
    static int mindiff=Integer.MAX_VALUE;
    static String res="";
    public static void solve(int arr[], int ind, ArrayList<Integer> set,ArrayList<Integer> set2,int sum1,int sum2){
    if(ind==arr.length){
       int ans=Math.abs(sum1-sum2);
       if(ans<mindiff){
           mindiff=ans;;
           res=set+" "+set2;
       }
        return;
    }
        if(set.size()< (arr.length+1)/2){
        set.add(arr[ind]);
        solve(arr,ind+1,set,set2,sum1+arr[ind],sum2);
        set.remove(set.size()-1);
    }
        if(set2.size()< (arr.length+1)/2) {
            set2.add(arr[ind]);
            solve(arr, ind + 1, set, set2, sum1, sum2 + arr[ind]);
            set2.remove(set2.size() - 1);
        }
    }

    public static void main(String[] args) {
        int arr[]={23, 45, -34, 12, 0, 98, -99, 4, 189, -1, 4};
        ArrayList<Integer> set=new ArrayList<>();
        ArrayList<Integer> set2=new ArrayList<>();

        solve(arr,0,set,set2,0,0);
        System.out.println("Minimum Difference: " + mindiff);
        System.out.println("Sets: " + res);
    }
}
