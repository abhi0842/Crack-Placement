package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    public static void subset(int start, int n, int k, ArrayList<Integer> curr, List<List<Integer>> res){
        if(curr.size()==k){
            res.add(new ArrayList<>(curr));
            return;
        }
        for(int i=start;i<=n;i++){
            curr.add(i);
            subset(i+1,n,k,curr,res);
            curr.remove(curr.size()-1);
        }
    }
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res=new ArrayList<>();
        subset(1,n,k,new ArrayList<>(),res);
        return res;
    }

    public static void main(String[] args) {
        int n=4;
        int k=2;
        System.out.println(combine(n,k));
    }
}
