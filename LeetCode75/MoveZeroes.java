package LeetCode75;

import java.util.*;
import java.io.*;

public class MoveZeroes {

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

    public static void moveZeroes(int[] nums) {
        int n = nums.length;
        int snowBall = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                snowBall++;
            } else if (snowBall > 0) {
                int t = nums[i];
                nums[i] = 0;
                nums[i - snowBall] = t;

            }
        }
    }

    public static void main(String[] args) throws Exception {
        FastReader input = new FastReader();
        pw = new PrintWriter(new BufferedWriter(new FileWriter("../DSA/output.txt")));
        int t = input.nextInt();

        while (t-- > 0) {
            int[] nums = Arrays.stream(input.nextLine().split(" ")).mapToInt(s -> Integer.parseInt(s))
                    .toArray();

            moveZeroes(nums);

            for (int i : nums) {
                pw.print(i + " ");
            }

            pw.println();
        }

        pw.flush();
    }
}