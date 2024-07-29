import java.util.Stack;

public class ValidParentheses {
    public static boolean isValid(String s) {
        Stack<Character> st=new Stack<>();
        for(char ch:s.toCharArray()){
            if(ch=='('){
                st.push(')');
            }
            else if(ch=='{'){
                st.push('}');
            }
            else if(ch=='['){
                st.push(']');
            }
            else if(st.isEmpty()||ch!=st.pop()){
                return false;
            }

        }
        return st.isEmpty();
    }

    public static void main(String[] args) {
        String s="()[]{}";
        System.out.println(isValid(s));
    }
}
