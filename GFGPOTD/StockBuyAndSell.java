package GFGPOTD;

import java.util.*;
import java.io.*;

public class StockBuyAndSell {

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

    public static int stockBuyAndSell(int n, int[] prices) {
        // code here

        int maxProfit = 0;
        int maxSum = 0;
        int minPrice = Integer.MAX_VALUE;

        for (int i = 1; i < n; i++) {
            int diff = prices[i] - prices[i - 1];
            maxProfit = Math.max(maxProfit + diff, diff);
            maxSum = Math.max(maxSum, maxProfit);
        }

        return maxProfit;
    }

    public static void main(String[] args) throws Exception {
        FastReader input = new FastReader();
        pw = new PrintWriter(new BufferedWriter(new FileWriter("../DSA/output.txt")));
        int t = input.nextInt();

        while (t-- > 0) {
            int n = input.nextInt();
            int arr[] = Arrays.stream(input.nextLine().split(" ")).mapToInt(s -> Integer.parseInt(s))
                    .toArray();

            pw.println(stockBuyAndSell(n, arr));
        }

        pw.flush();
    }
}