package Heap;

public class RecoganizeString {
    static String reorganizeString(String str) {
        int[] map = new int[26];
        for (int i = 0; i < str.length(); i++){
            map[str.charAt(i) - 'a']++;
        }
        int max = 0, ch = 0;
        for (int i = 0; i < map.length; i++)
            if (map[i] > max) {
                max = map[i];
                ch = i;
            }

        if (max > (str.length() + 1) / 2){
            return "";
        }

        char[] res = new char[str.length()];
        int idx = 0;
        while (map[ch]-- > 0) {
            res[idx] = (char) (ch + 'a');
            idx += 2;
        }

        for (int i = 0; i < map.length; i++)
            while (map[i]-- > 0) {
                if (idx >= res.length) idx = 1;

                res[idx] = (char) (i + 'a');
                idx += 2;
            }

        return String.valueOf(res);
    }

    public static void main(String[] args) {
        System.out.println(reorganizeString("aab"));
    }
}
