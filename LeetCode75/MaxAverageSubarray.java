package LeetCode75;

import java.util.*;
import java.io.*;

public class MaxAverageSubarray {

    public static PrintWriter pw;

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() throws FileNotFoundException {
            br = new BufferedReader(
                    new FileReader("../DSA/input.txt"));
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

    public static double findMaxAverage(int[] nums, int k) {
        int n = nums.length;
        int sum = 0;

        if (k > n)
            return 0;

        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }

        double avg = ((double) sum) / k;

        for (int i = 1; i <= n - k; i++) {
            sum = sum - nums[i - 1];
            sum += nums[i + k - 1];

            avg = Math.max(avg, ((double) sum) / k);
        }

        return avg;
    }

    public static void main(String[] args) throws Exception {
        FastReader input = new FastReader();
        pw = new PrintWriter(new BufferedWriter(new FileWriter("../DSA/output.txt")));
        int t = input.nextInt();

        while (t-- > 0) {
            int arr[] = Arrays.stream(input.nextLine().split(" ")).mapToInt(s -> Integer.parseInt(s))
                    .toArray();
            int k = input.nextInt();

            pw.println(findMaxAverage(arr, k));
        }

        pw.flush();
    }
}