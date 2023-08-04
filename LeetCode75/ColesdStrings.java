package LeetCode75;

import java.util.*;
import java.io.*;

public class ColesdStrings {

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

    public static boolean closeStrings(String word1, String word2) {

        if (word1.length() != word2.length())
            return false;

        int[] s1 = new int[26];
        int[] s2 = new int[26];
        int[] c1 = new int[26];
        int[] c2 = new int[26];

        for (int i = 0; i < word1.length(); i++) {
            char ch = word1.charAt(i);
            s1[ch - 'a']++;
            c1[ch - 'a'] = 1;
        }
        for (int i = 0; i < word2.length(); i++) {
            char ch = word2.charAt(i);
            s2[ch - 'a']++;
            c2[ch - 'a'] = 1;
        }
        Arrays.sort(s1);
        Arrays.sort(s2);
        return Arrays.equals(s1, s2) && Arrays.equals(c1, c2);

    }

    public static void main(String[] args) throws Exception {
        FastReader input = new FastReader();
        pw = new PrintWriter(new BufferedWriter(new FileWriter("../DSA/output.txt")));
        int t = input.nextInt();

        while (t-- > 0) {
            String str1 = input.nextLine();
            String str2 = input.nextLine();

            pw.println(closeStrings(str1, str2));
        }

        pw.flush();
    }
}