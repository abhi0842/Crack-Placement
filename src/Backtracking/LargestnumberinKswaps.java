package Backtracking;

public class LargestnumberinKswaps {
    private static String maxNumber;
    private static String swap(String str, int i, int j) {
        char[] charArray = str.toCharArray();
        char temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return new String(charArray);
    }
    private static void findMaximumnum(String str, int k) {
        if (k == 0) {
            return;
        }

        int n = str.length();
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {

                if (str.charAt(j) > str.charAt(i)) {

                    String swapped = swap(str, i, j);
                    if (swapped.compareTo(maxNumber) > 0) {
                        maxNumber = swapped;
                    }
                    findMaximumnum(swapped, k - 1);  // Ensure the correct method name here
                }
            }
        }
    }
    public static String findMaximumNum(String str, int k) {
        maxNumber = str;
        findMaximumnum(str, k);
        return maxNumber;
    }
}
