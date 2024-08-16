package Trie;

import java.util.*;

public class PalindromicPair {
    public static List<List<Integer>> palindromePairs(String[] word) {
        HashMap<String,Integer> map=new HashMap<>();
        List<List<Integer>> res=new ArrayList<>();
        Set<Integer> set=new TreeSet<>();
        int n=word.length;
        for(int i=0;i<n;i++){
            map.put(word[i],i);
            set.add(word[i].length());
        }

        for(int i=0;i<n;i++){
            int length=word[i].length();
            if(length==1){
                if(map.containsKey("")){
                    res.add(Arrays.asList(i,map.get("")));
                    res.add(Arrays.asList(map.get(""),i));
                }
                continue;

            }
            String reverse=new StringBuilder(word[i]).reverse().toString();
            if(map.containsKey(reverse)&&map.get(reverse)!=i)
                res.add(Arrays.asList(i,map.get(reverse)));

            for(Integer k:set){
                if(k==length){
                    break;
                }
                if(isPalindrome(reverse,0,length-1-k)){
                    String s1=reverse.substring(length-k);
                    if(map.containsKey(s1))
                        res.add(Arrays.asList(i,map.get(s1)));
                }

                if(isPalindrome(reverse,k,length-1)){
                    String s2=reverse.substring(0,k);
                    if(map.containsKey(s2))
                        res.add(Arrays.asList(map.get(s2),i));
                }
            }
        }
        return res;
    }
    private static boolean isPalindrome(String s,int left,int right) {

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        String[] arr={"abcd","dcba","lls","s","sssll"};
        System.out.println(palindromePairs(arr));
    }
}
