package LeetCode75;

import java.util.*;
import java.io.*;

public class ReverseWords {

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

    public static String reverseWords(String s) {
        String res = "";
        String[] strArr = s.trim().split("\\s+");

        int i = 0;
        int j = strArr.length - 1;

        while (i < j) {
            String str = strArr[i];
            strArr[i] = strArr[j];
            strArr[j] = str;

            i++;
            j--;
        }

        for (int k = 0; k < strArr.length - 1; k++)
            res += strArr[k] + " ";

        res += strArr[strArr.length - 1];

        return res;
    }

    public static void main(String[] args) throws Exception {
        FastReader input = new FastReader();
        pw = new PrintWriter(new BufferedWriter(new FileWriter("../DSA/output.txt")));
        int t = input.nextInt();

        while (t-- > 0) {
            String s = input.nextLine();

            pw.println(reverseWords(s));
        }

        pw.flush();
    }
}
