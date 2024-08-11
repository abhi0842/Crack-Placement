package Stack;

import java.util.Stack;

public class evaluatePostFix{
    public static int evaluate(String S)
    {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);


            if (Character.isDigit(ch)) {
                stack.push(ch - '0');
            }

            else {
                int val2 = stack.pop();
                int val1 = stack.pop();

                switch (ch) {
                    case '+':
                        stack.push(val1 + val2);
                        break;
                    case '-':
                        stack.push(val1 - val2);
                        break;
                    case '*':
                        stack.push(val1 * val2);
                        break;
                    case '/':
                        stack.push(val1 / val2);
                        break;
                }
            }
        }
        return stack.pop();

    }

    public static void main(String[] args) {
        String S = "231*+9-";
        System.out.println(evaluate(S));
    }
}
