package LeetCode75;

import java.util.*;
import java.io.*;

public class StringCompress {

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

    //My Sol - Didn't pass
    public static int compressSolution(char[] chars) {
        int n = chars.length;
        String res = "";

        int count = 0;
        char c = chars[0];

        int index = -1;

        for (int i = 0; i < n; i++) {
            if (chars[i] == c) {
                count++;
                continue;
            } else {
                if (count > 1) {
                    res += String.valueOf(c) + String.valueOf((char) (count + '0'));

                    index++;
                    chars[index] = c;
                    index++;
                    chars[index] = (char) (count + '0');
                } else {
                    res += String.valueOf(c);

                    index++;
                    chars[index] = c;
                }

                c = chars[i];
                count = 1;
            }
        }

        res += String.valueOf(c);
        if (count > 1)
            res += String.valueOf((char) (count + '0'));

        index++;
        chars[index] = c;

        if (count > 1)
            chars[++index] = (char) (count + '0');

        pw.println((char) (count + '0'));

        return res.length();
    }

    public static int compress(char[] chars) {
        int i=0;
        int res = 0;

        while(i < chars.length){
            int groupLength = 1;
            while (i + groupLength < chars.length && chars[i + groupLength] == chars[i]) {
                groupLength++;
            }
            chars[res++] = chars[i];
            if (groupLength > 1) {
                for (char c : Integer.toString(groupLength).toCharArray()) {
                    chars[res++] = c;
                }
            }
            i += groupLength;
        }

        return res;
    }

    public static void main(String[] args) throws Exception {
        FastReader input = new FastReader();
        pw = new PrintWriter(new BufferedWriter(new FileWriter("../DSA/output.txt")));
        int t = input.nextInt();

        while (t-- > 0) {
            char[] chars = input.nextLine().toCharArray();

            pw.println(compress(chars));
        }

        pw.flush();
    }
}