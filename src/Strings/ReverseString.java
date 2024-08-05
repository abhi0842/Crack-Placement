package Strings;

public class ReverseString {
    public static String reverse(String s){
        String st=s.replaceAll("\\s+"," ");
       String arr[]=st.trim().split(" ");
       int i=0;
       int j=arr.length-1;
       while(i<=j){
           String temp=arr[i];
           arr[i]=arr[j];
           arr[j]=temp;
           i++;
           j--;
       }
       return String.join(" ",arr);
    }

    public static void main(String[] args) {
        String str="  Hello   World   ";
        System.out.println(reverse(str));
    }
}
