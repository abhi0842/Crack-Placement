package Graph;

public class minimizecashflow {
    static final int N = 3;

    // A utility function that returns
// index of minimum value in arr[]
    static int getMin(int arr[]) {
        int minInd = 0;
        for (int i = 1; i < N; i++)
            if (arr[i] < arr[minInd])
                minInd = i;
        return minInd;
    }

    // A utility function that returns
// index of maximum value in arr[]
    static int getMax(int arr[]) {
        int maxInd = 0;
        for (int i = 1; i < N; i++)
            if (arr[i] > arr[maxInd])
                maxInd = i;
        return maxInd;
    }

    // A utility function to return minimum of 2 values
    static int minOf2(int x, int y) {
        return (x < y) ? x : y;
    }

    // amount[p] indicates the net amount
// to be credited/debited to/from person 'p'
    static void minCashFlowRec(int amount[]) {
        int mxCredit = getMax(amount), mxDebit = getMin(amount);

        // If both amounts are 0, then
        // all amounts are settled
        if (amount[mxCredit] == 0 && amount[mxDebit] == 0)
            return;

        // Find the minimum of two amounts
        int min = minOf2(-amount[mxDebit], amount[mxCredit]);
        amount[mxCredit] -= min;
        amount[mxDebit] += min;

        System.out.println("Person " + mxDebit + " pays " + min
                + " to " + "Person " + mxCredit);

        minCashFlowRec(amount);
    }

    // Given a set of persons as graph[]
// where graph[i][j] indicates
// the amount that person i needs to
// pay person j, this function
// finds and prints the minimum
// cash flow to settle all debts.
    static void minCashFlow(int graph[][]) {
        int amount[] = new int[N];

        for (int p = 0; p < N; p++)
            for (int i = 0; i < N; i++)
                amount[p] += (graph[i][p] - graph[p][i]);

        minCashFlowRec(amount);
    }

    // Driver code
    public static void main (String[] args) {
        int graph[][] = { {0, 1000, 2000},
                {0, 0, 5000},
                {0, 0, 0}, };

        minCashFlow(graph);
    }
}
