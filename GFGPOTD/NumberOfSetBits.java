package GFGPOTD;

import java.util.*;
import java.io.*;

public class NumberOfSetBits {

    public static PrintWriter pw;

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() throws FileNotFoundException {
            br = new BufferedReader(
                    new FileReader("/Users/puruagarwal/dev/java/DSA/input.txt"));
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

    static int solution(int n) {
        int count = 0;
        
        while(n != 0){
            if ((n & 1) == 1) {
                count++;
            }

            n >>= 1;
        }

        return count;
    }

    public static void main(String[] args) throws Exception {
        FastReader input = new FastReader();
        pw = new PrintWriter(new BufferedWriter(new FileWriter("/Users/puruagarwal/dev/java/DSA/output.txt")));
        int t = input.nextInt();

        while (t-- > 0) {
            int n = input.nextInt();

            pw.println(solution(n));
        }

        pw.flush();
    }
}