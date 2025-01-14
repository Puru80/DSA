package LeetCode75;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.io.*;

public class MaxVowels {

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

    static HashSet<Character> vowels = Stream.of(
            'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U')
            .collect(Collectors.toCollection(HashSet::new));
    // {
    // vowels.add('a');
    // vowels.add('e');
    // vowels.add('i');
    // vowels.add('o');
    // vowels.add('u');
    // vowels.add('A');
    // vowels.add('E');
    // vowels.add('I');
    // vowels.add('O');
    // vowels.add('U');
    // }
    // };

    public static int maxVowels(String s, int k) {
        int n = s.length();
        int res = 0;
        int count = 0;

        String subString = s.substring(0, k);

        for (int i = 0; i < subString.length(); i++) {
            if (vowels.contains(subString.charAt(i)))
                count++;
        }

        res = count;

        for (int i = 1; i <= n - k; i++) {

            if (vowels.contains(s.charAt(i - 1)))
                --count;
            if (vowels.contains(s.charAt(i + k - 1)))
                ++count;

            res = Math.max(res, count);
        }

        return res;
    }

    public static void main(String[] args) throws Exception {
        FastReader input = new FastReader();
        pw = new PrintWriter(new BufferedWriter(new FileWriter("../DSA/output.txt")));
        int t = input.nextInt();

        while (t-- > 0) {
            String s = input.nextLine();
            int k = input.nextInt();

            pw.println(maxVowels(s, k));
        }

        pw.flush();
    }
}