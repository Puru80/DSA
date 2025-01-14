package GFGPOTD;

import java.util.*;
import java.io.*;

public class NextHappyNumber {

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

    public static int calculateDigitSquareSum(int n) {
        int sum = 0;
        while (n > 0) {
            int digit = n % 10;
            sum += digit * digit;
            n /= 10;
        }
        return sum;
    }

    public static boolean isHappyNumber(int n) {
        int slow = n;
        int fast = n;
        do {
            slow = calculateDigitSquareSum(slow);
            fast = calculateDigitSquareSum(fast);
            fast = calculateDigitSquareSum(fast);
        } while (slow != fast);
        return slow == 1;
    }

    public static int nextHappy(int n) {
        n++; // Start checking from the next number
        while (true) {
            if (isHappyNumber(n)) {
                return n;
            }
            n++;
        }
    }

    public static void main(String[] args) throws Exception {
        FastReader input = new FastReader();
        pw = new PrintWriter(new BufferedWriter(new FileWriter("../DSA/output.txt")));
        int t = input.nextInt();

        while (t-- > 0) {
            int n = input.nextInt();

            pw.println(nextHappy(n));
        }

        pw.flush();
    }
}
