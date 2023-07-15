package LeetCode75;

import java.util.*;
import java.io.*;

public class IsSubsequence {

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

    public static boolean isSubsequence(String s, String t) {
        int l = s.length();
        int r = t.length();
        int k = 0;

        if (r == 0)
            return true;
        if (l > r)
            return false;

        for (int i = 0; i < r; i++) {
            if (s.charAt(k) == t.charAt(i)) {
                if (k == l - 1)
                    return true;
                k++;
            }
        }

        return false;
    }

    public static void main(String[] args) throws Exception {
        FastReader input = new FastReader();
        pw = new PrintWriter(new BufferedWriter(new FileWriter("../DSA/output.txt")));
        int t = input.nextInt();     

        while (t-- > 0) {
            String s = input.nextLine();
            String k = input.nextLine();

            pw.println(isSubsequence(s, k));
        }

        pw.flush();
    }
}