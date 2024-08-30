package Greedy;

public class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        int[] taskCounts = new int[26];
        for (char task : tasks) {
            taskCounts[task - 'A']++;
        }


        int maxFreq = 0;
        for (int count : taskCounts) {
            maxFreq = Math.max(maxFreq, count);
        }
        int maxFreqCount = 0;
        for (int count : taskCounts) {
            if (count == maxFreq) {
                maxFreqCount++;
            }
        }

        int partCount = maxFreq - 1;
        int partLength = n - (maxFreqCount - 1);
        int emptySlots = partCount * partLength;
        int availableTasks = tasks.length - maxFreq * maxFreqCount;
        int idles = Math.max(0, emptySlots - availableTasks);

        return tasks.length + idles;
    }
}
