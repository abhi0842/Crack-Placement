package Strings;

import java.util.Stack;

public class SimplifyPath {
    public static String simplifyPath(String path) {
        Stack<String> st=new Stack<>();
        String[]arr=path.split("/");
        for(String i:arr){
            if(i.equals("..")&&!st.empty()){
                st.pop();
            }
            else if(!i.equals("")&&!i.equals(".")&&!i.equals("..")){
                st.push(i);
            }
        }
        StringBuilder sb=new StringBuilder();
        for(String i:st){
            sb.append("/");
            sb.append(i);
        }
        return sb.length()==0? "/":sb.toString();
    }

    public static void main(String[] args) {
        String s= "/home/user/Documents/../Pictures";
        System.out.println(simplifyPath(s));
    }
}
