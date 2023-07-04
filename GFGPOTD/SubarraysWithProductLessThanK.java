package GFGPOTD;

import java.util.*;
import java.io.*;

public class SubarraysWithProductLessThanK {

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

    static int countSubArrayProductLessThanK(long a[], int n, long k) {
        int count = 0;
        int product = 1;
        int left = 0;

        for (int i = 0; i < n; i++) {
            product *= a[i];
            
            while(product >= k && left <= i){
                product /= a[left];
                left++;
            }

            count += i - left + 1;
        }

        return count;
    }

    public static void main(String[] args) throws Exception {
        FastReader input = new FastReader();
        pw = new PrintWriter(new BufferedWriter(new FileWriter("../DSA/output.txt")));
        int t = input.nextInt();

        while (t-- > 0) {
            int n = input.nextInt();
            int k = input.nextInt();

            long arr[] = Arrays.stream(input.nextLine().split(" ")).mapToLong(s -> Long.parseLong(s))
                    .toArray();

            pw.println(countSubArrayProductLessThanK(arr, n, k));
        }

        pw.flush();
    }
}