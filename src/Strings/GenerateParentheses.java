package Strings;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public static List<String> generateParenthesis(int n) {
        List<String>[] dp =new List[n+1];
      //  dp[0]= Arrays.asList("");
        //dp[1]= Arrays.asList("()");
        for(int i=2;i<=n;i++){
            dp[i]=new ArrayList<>();
            int start=i-1;
            int outer=0;
            while(start>=0&&outer<=i-1){
                for(String in:dp[start]){
                    for(String out:dp[outer]){
                        StringBuilder sb=new StringBuilder();
                        sb.append("(");
                        sb.append(in);
                        sb.append(")");
                        sb.append(out);
                        dp[i].add(sb.toString());

                    }
                }
                start--;
                outer++;
            }
        }

        return dp[n];
    }
}
