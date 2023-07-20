package LeetCode75;

import java.util.*;
import java.io.*;

public class LargestAltitude {

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

    public static int largestAltitude(int[] gain) {
        int n = gain.length;

        int prev = gain[0];
        int res=0;

        res = Math.max(res, prev);

        for (int i = 1; i < n; i++) {
            prev += gain[i];
 
            res = Math.max(res, prev);
        }

        return res;
    }

    public static void main(String[] args) throws Exception {
        FastReader input = new FastReader();
        pw = new PrintWriter(new BufferedWriter(new FileWriter("../DSA/output.txt")));
        int t = input.nextInt();

        while (t-- > 0) {
            int[] gain = Arrays.stream(input.nextLine().split(" ")).mapToInt(s -> Integer.parseInt(s))
                    .toArray();
            pw.println(largestAltitude(gain));
        }

        pw.flush();
    }
}