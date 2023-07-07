package LeetCode75;

import java.util.*;
import java.io.*;

public class StringMergeAlternate {

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

    static String mergeAlternately(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        int i = 0;
        int j = 0;

        String result = "";

        for (i = 0, j = 0; i < n && j < m; i++, j++) {
            result += (String.valueOf(word1.charAt(i)) + String.valueOf(word2.charAt(j)));
        }

        if (i == n) {
            while (j < m){
                result += word2.charAt(j);
                j++;
            }
        }
        if(j == m){
            while (i < n){
                result += word1.charAt(i);
                i++;
            }
        }

        return result;
    }

    public static void main(String[] args) throws Exception {
        FastReader input = new FastReader();
        pw = new PrintWriter(new BufferedWriter(new FileWriter("../DSA/output.txt")));
        int t = input.nextInt();

        while (t-- > 0) {
            String str1 = input.nextLine();
            String str2 = input.nextLine();

            pw.println(mergeAlternately(str1, str2));
        }

        pw.flush();
    }
}