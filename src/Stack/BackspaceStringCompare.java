package Stack;

public class BackspaceStringCompare {
    public boolean backspaceCompare(String s, String t) {
        return buildFinalString(s).equals(buildFinalString(t))  ;
    }

    private String buildFinalString(String str) {
        //here we are using stringbuilder as a stack
        StringBuilder result = new StringBuilder();

        for (char c : str.toCharArray()) {
            if (c == '#') {
                //if our element is # then we simply reduce the string length by one

                if (result.length() > 0) {
                    result.deleteCharAt(result.length() - 1);
                }
            } else {
                result.append(c);
            }
        }

        return result.toString();
    }
}
