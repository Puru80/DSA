package GFGPOTD;

import java.util.*;
import java.io.*;

public class TaaskScheduler {

    public static PrintWriter pw;

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() throws FileNotFoundException {
            br = new BufferedReader(
                    new FileReader("/Users/puruagarwal/dev/java/DSA/input.txt"));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

    static int leastInterval(int N, int K, char tasks[]) {
        // code here
        Map<Character, Integer> taskCounts = new HashMap<>();
        int maxFrequency = 0;
        int maxCount = 0;

        for (char task : tasks) {
            int count = taskCounts.getOrDefault(task, 0) + 1;
            taskCounts.put(task, count);

            if (count > maxFrequency) {
                maxFrequency = count;
                maxCount = 1;
            } else if (count == maxFrequency) {
                maxCount++;
            }
        }

        int partitions = maxFrequency - 1;
        int emptySlots = partitions * (K - maxCount + 1);
        int pendingTasks = tasks.length - (maxFrequency * maxCount);
        int idleSlots = Math.max(0, emptySlots - pendingTasks);

        return tasks.length + idleSlots;

    }

    public static void main(String[] args) throws Exception {
        FastReader input = new FastReader();
        pw = new PrintWriter(new BufferedWriter(new FileWriter("/Users/puruagarwal/dev/java/DSA/output.txt")));
        int t = input.nextInt();

        while (t-- > 0) {
            int n = input.nextInt();
            int k = input.nextInt();

            char[] tasks = input.nextLine().toCharArray();

            pw.println(leastInterval(n, k, tasks));
        }

        pw.flush();
    }
}