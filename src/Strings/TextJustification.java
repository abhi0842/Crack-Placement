package Strings;

import java.util.*;

public class TextJustification {
    static int Max_Width;
    public static List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res=new ArrayList<>();
        int n=words.length;
        Max_Width=maxWidth;
        int i=0;
        while(i<n){
            int letterCount=words[i].length();
            int j=i+1;
            int spaceslot=0;
            while(j<n&&words[j].length()+1+spaceslot+letterCount<=maxWidth){
                letterCount+=words[j].length();
                spaceslot+=1;
                j++;
            }
            int   remslot=maxWidth-letterCount;

            int eachspaceSlot=spaceslot==0?0:remslot/spaceslot;
            int  extraspace=spaceslot==0?0:remslot%spaceslot;

            if(j==n){
                eachspaceSlot=1;
                extraspace=0;

            }
            res.add(findLine(i,j,eachspaceSlot,extraspace,words));
            i=j;
        }
        return res;
    }
    public static   String findLine(int i,int j,int eachspaceSlot,int extraspace,String[]words ){
        String line="";
        for(int k=i;k<j;k++){
            line+=words[k];
            if(k==j-1){
                break;
            }
            for(int z=1;z<=eachspaceSlot;z++){
                line+=" ";
            }
            if(extraspace>0){
                line+=" ";
                extraspace--;
            }
        }
        while(line.length()<Max_Width){
            line+=" ";
        }
        return line;
    }

    public static void main(String[] args) {
        String[] s={"This", "is", "an", "example", "of", "text", "justification."};
        int maxWidth = 16;
        System.out.println(fullJustify(s,maxWidth));
    }
}
