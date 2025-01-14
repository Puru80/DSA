package LeetCode75;

import java.util.*;
import java.io.*;

public class ReverseVowelsString {

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

    static boolean isVowel(char c) {
        return (c == 'a' || c == 'A' || c == 'e'
                || c == 'E' || c == 'i' || c == 'I'
                || c == 'o' || c == 'O' || c == 'u'
                || c == 'U');
    }

    public static String reverseVowels(String s) {
        int i = 0;
        int j = s.length() - 1;
        char[] str = s.toCharArray();

        while (i < j) {
            if (!isVowel(str[i])) {
                i++;
                continue;
            }
            if (!isVowel(str[j])) {
                j--;
                continue;
            }

            char c = str[i];
            str[i] = str[j];
            str[j] = c;

            i++;
            j--;
        }

        String res = String.copyValueOf(str);

        return res;
    }

    public static void main(String[] args) throws Exception {
        FastReader input = new FastReader();
        pw = new PrintWriter(new BufferedWriter(new FileWriter("../DSA/output.txt")));
        int t = input.nextInt();

        while (t-- > 0) {
            String s = input.nextLine();

            pw.println(reverseVowels(s));
        }

        pw.flush();
    }
}
