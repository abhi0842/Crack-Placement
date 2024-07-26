import org.w3c.dom.ls.LSOutput;

import java.util.Stack;

public class decode_string {
    public static String decodeString(String s) {

        Stack<Integer> numStack = new Stack<>();
        Stack<String> stringStack = new Stack<>();
        int count = 0;

        for (char c : s.toCharArray()) {

            if (Character.isDigit(c)) {
                count = (count * 10) + (c - '0');
                continue;
            }

            if (c == '[') {
                numStack.push(count );
                count = 0;
                stringStack.push(String.valueOf(c));
                continue;
            }

            if (c != ']') {
                stringStack.push(String.valueOf(c));
                continue;
            }

            StringBuilder temp = new StringBuilder();
            while (!stringStack.peek().equals("["))
                temp.insert(0, stringStack.pop());


            stringStack.pop();


            StringBuilder replacement = new StringBuilder();
            int k = numStack.pop();
            for (int i = 0; i < k; i++)
                replacement.append(temp);


            stringStack.push(replacement.toString());
        }

        StringBuilder result = new StringBuilder();
        while (!stringStack.empty()) {
            result.insert(0, stringStack.pop());
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String s="3[a]2[bc]";
        System.out.println(decodeString(s));
    }
}
