package Strings;

import java.util.HashMap;

public class MinimumWindowSubstring {
    public static String minWindow(String s, String t) {
        String ans="";
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<t.length();i++){
            char ch=t.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);

        }
        //mct=matchCount
        //dmct=desiredMatchCount
        int mct=0;
        int  dmct=t.length();
        HashMap<Character,Integer> map1=new HashMap<>();
        int i=-1;
        int j=-1;
        while(true){
            boolean f=false;
            boolean f1=false;
            while(i<s.length()-1 &&  mct<dmct){
                i++;
                char ch=s.charAt(i);
                map1.put(ch,map1.getOrDefault(ch,0)+1);
                if(map1.getOrDefault(ch,0)<=map.getOrDefault(ch,0)){
                    mct++;
                }
                f=true;
            }
            while(j<i&&mct==dmct){
                String pans=s.substring(j+1,i+1);
                if(ans.length()==0||pans.length()<ans.length()){
                    ans=pans;
                }
                j++;
                char ch=s.charAt(j);
                if(map1.get(ch)==1){
                    map1.remove(ch);
                }
                else{
                    map1.put(ch,map1.get(ch)-1);
                }
                if(map1.getOrDefault(ch,0)<map.getOrDefault(ch,0)){
                    mct--;
                }
                f1=true;
            }
            if(f==false&&f1==false){
                break;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC", t = "ABC";
        System.out.println(minWindow(s,t));
    }
}
