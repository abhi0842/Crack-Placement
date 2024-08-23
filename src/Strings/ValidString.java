package Strings;

import java.util.Stack;

public class ValidString {
    static boolean isNumber(String s) {
        boolean digit=false;
        boolean eseen=false;
        boolean dotseen=false;
        int count=0;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);

            if(Character.isDigit(ch)){
                digit=true;
            }
            else  if(ch=='+'||ch=='-'){
                if(count==2){
                    return false;
                }
                if(i>0&&s.charAt(i-1)!='e'&&s.charAt(i-1)!='E'){
                    return false;
                }
                if(i==s.length()-1){
                    return false;
                }
                count++;
            }
            else if(ch=='.'){
                if(eseen||dotseen){
                    return false;
                }
                if(i==s.length()-1&&!digit){
                    return false;
                }
                dotseen=true;
            }
            else if(ch=='e'||ch=='E'){
                if(eseen||!digit||i==s.length()-1){
                    return false;
                }
                eseen =true;
                digit=false;
            }
            else{
                return false;
            }

        }
        return digit;
    }

    public static void main(String[] args) {
        System.out.println(isNumber("1"));
    }
}
