package Stack;

import java.util.Stack;

public class OnlineStockSpan {
    Stack<int[]> st;
    public OnlineStockSpan() {
        st = new Stack<>();
    }

    public int next(int price) {
        int span=1;
        while(!st.isEmpty()&&st.peek()[0]<=price){
            span+=st.pop()[1];

        }
        st.push(new int[]{price, span});
        return span;
    }
}
