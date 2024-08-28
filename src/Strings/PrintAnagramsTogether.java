package Strings;

import java.util.*;

public class PrintAnagramsTogether {
    public static List<List<String>> Anagrams(String[] string_list) {

        if (string_list == null || string_list.length == 0) {
            return Collections.emptyList();
        }
        Map<String, List<String>> anagramMap = new HashMap<>();
        for (String str : string_list) {
            if (str == null || str.isEmpty()) {
                continue;
            }
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sortedStr = new String(charArray);
            anagramMap.computeIfAbsent(sortedStr, k -> new ArrayList<>()).add(str);
        }
        List<List<String>> result = new ArrayList<>(anagramMap.values());
        result.sort(Comparator.comparing(o -> o.get(0)));

        return result;
    }

    public static void main(String[] args) {
      String  words[] = {"act","god","cat","dog","tac"};
        System.out.println(Anagrams(words));
    }
}
