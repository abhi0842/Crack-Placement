package Stack;

import java.util.Stack;

public class ReversePolishNotation {
    public static int helper(int a, int b, String s) {
        if (s.equals("+"))
            return a + b;

        if (s.equals("-"))
            return a - b;

        if (s.equals("*"))
            return (int) ((long) a * (long) b);

        if (s.equals("/"))
            return a / b;

        return -1;
    }
    public static int evalRPN(String[] tokens) {
        int res=0;
        Stack<Integer> stack=new Stack<>();
        for(String ele:tokens){
            if(ele.equals("+") || ele.equals("-") || ele.equals("*") ||ele.equals("/")){

                int b=stack.pop();
                int a=stack.pop();
                res=helper(a,b,ele);
                stack.push(res);

            }
            else{
                stack.push(Integer.parseInt(ele));
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        String[] tokens={"2","1","+","3","*"};
        System.out.println(evalRPN(tokens));
    }
}
