package Strings;

import java.util.HashMap;
import java.util.Map;

public class SmallestWindowSubstring {
    public static String smallestWindow(String s, String p){
        if(p==""){
            return "-1";
        }
        if(p.length()>s.length()){
            return "-1";
        }
        if(s.equals(p)){
            return s;
        }

        Map<Character,Integer> pmap= new HashMap<>();
        Map<Character,Integer> smap= new HashMap<>();
        for(int i=0;i<p.length();i++)
            pmap.put(p.charAt(i),pmap.getOrDefault(p.charAt(i),0)+1);

        int currlen=0;
        int totallen=pmap.size();
        String res="-1";
        int reslen=Integer.MAX_VALUE;
        int left=0;
        int right=0;
        while(right<s.length()){
            char ch=s.charAt(right);
            smap.put(ch,smap.getOrDefault(ch,0)+1);
            if(pmap.containsKey(ch)&&pmap.get(ch)==smap.get(ch))
                currlen++;

            while(currlen==totallen){
                if((right-left+1)<reslen){
                    res=s.substring(left,right+1);
                    reslen=right-left+1;
                }
                char temp=s.charAt(left);
                smap.put(temp,smap.get(temp)-1);
                if(pmap.containsKey(temp)&&smap.get(temp)<pmap.get(temp))
                    currlen--;

                left++;

            }
            right++;
        }
        return (reslen!=Integer.MAX_VALUE)?res:"-1";
    }

    public static void main(String[] args) {
        String s="zoomlazapzo";
        String p="oza";

        System.out.println(smallestWindow(s,p));
    }
}
