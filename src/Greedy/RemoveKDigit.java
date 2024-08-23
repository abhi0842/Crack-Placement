package Greedy;

import java.util.Stack;

public class RemoveKDigit {
    public static String removeKdigits(String num, int k) {
        int n=num.length();
        if(k==n){
            return "0";
        }
        Stack<Character> st=new Stack<>();
        for(int i=0;i<n;i++){
            char ch=num.charAt(i);
            while(!st.isEmpty()&&k>0&&st.peek()>ch){
                st.pop();
                k--;
            }
            st.push(ch);
        }
        while(k>0){
            st.pop();
            k--;
        }
        StringBuilder res=new StringBuilder();
        while(!st.isEmpty()){
            res.append(st.pop());

        }
        res.reverse();
        while(res.length()>1&&res.charAt(0)=='0'){
            res.deleteCharAt(0);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        String s="1432219";
        int  k = 3;
        System.out.println(removeKdigits(s,k));
    }
}
