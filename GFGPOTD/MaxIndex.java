package GFGPOTD;

import java.util.*;
import java.io.*;

public class MaxIndex {

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

    static int maxIndexDiff(int arr[], int n) {
        // code here

        int minArr[] = new int[n];
        int maxArr[] = new int[n];

        minArr[0] = arr[0];
        maxArr[n - 1] = arr[n - 1];
        for (int i = 1; i < n; i++) {
            minArr[i] = Math.min(arr[i], minArr[i - 1]);
            maxArr[n - 1 - i] = Math.max(arr[n - 1 - i], maxArr[n - i]);
        }

        int i = 0, j = 0, maxIndex = -1;

        while (i < n && j < n) {
            if (minArr[i] <= maxArr[j]) {
                maxIndex = Math.max(maxIndex, j - 1);
                j++;
            } else
                i++;
        }

        return maxIndex;
    }

    public static void main(String[] args) throws Exception {
        FastReader input = new FastReader();
        pw = new PrintWriter(new BufferedWriter(new FileWriter("/Users/puruagarwal/dev/java/DSA/output.txt")));
        int t = input.nextInt();

        while (t-- > 0) {
            int n = input.nextInt();
            int arr[] = Arrays.stream(input.nextLine().split(" ")).mapToInt(s -> Integer.parseInt(s))
                    .toArray();

            pw.println(maxIndexDiff(arr, n));
        }

        pw.flush();
    }
}
