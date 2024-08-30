package Stack;

public class TwoStackinArray {
    int n;
    private int[] arr;
    private int top1, top2;
    private int capacity;
    TwoStackinArray() {
        arr = new int[n];
        capacity = n;
        top1 = -1;
        top2 = n;
    }


    void push1(int x) {
        if (top1 < top2 - 1) {
            arr[++top1] = x;
        } else {
            System.out.println("Stack Overflow");
        }
    }


    void push2(int x) {
        if (top1 < top2 - 1) {
            arr[--top2] = x;
        } else {
            System.out.println("Stack Overflow");
        }
    }

    int pop1() {
        if (top1 >= 0) {
            return arr[top1--];
        } else {
            return -1;
        }
    }

    int pop2() {
        if (top2 < capacity) {
            return arr[top2++];
        } else {
            return -1;
        }
    }

}
