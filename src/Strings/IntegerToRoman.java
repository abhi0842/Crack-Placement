package Strings;

public class IntegerToRoman {
    public static String intToRoman(int num) {
        String unit[]={"","I","II","III","IV","V","VI","VII","VIII","IX"};
        String ten[]={"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"};
        String hundred[]={"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"};
        String thou[]={"","M","MM","MMM"};
        return thou[num/1000]+
                hundred[(num%1000)/100]+
                ten[(num%100)/10]+
                unit[num%10];

    }

    public static void main(String[] args) {
        int num=564;
        System.out.println(intToRoman(num));
    }
    }
