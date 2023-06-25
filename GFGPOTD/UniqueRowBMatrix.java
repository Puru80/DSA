package GFGPOTD;

import java.util.*;
import java.io.*;

public class UniqueRowBMatrix {

    public static PrintWriter pw;

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() throws FileNotFoundException {
            br = new BufferedReader(
                    new FileReader("/Users/puruagarwal/dev/java/DSA/output.txt"));
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

    public static ArrayList<ArrayList<Integer>> uniqueRow(int a[][], int r, int c) {
        // add code here.
        
        Set<String> uniqueRows = new LinkedHashSet<>();
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        for (int[] row : a) {
            StringBuilder rowString = new StringBuilder();
            for (int num : row) {
                rowString.append(num);
            }

            String rowKey = rowString.toString();
            if (!uniqueRows.contains(rowKey)) {
                uniqueRows.add(rowKey);

                ArrayList<Integer> list = new ArrayList<>(row.length);
                for (int num : row) {
                    list.add(num);
                }

                result.add(list);
            }

        }

        return result;
    }

    public static void main(String[] args) throws Exception {
        FastReader input = new FastReader();
        pw = new PrintWriter(new BufferedWriter(new FileWriter("/Users/puruagarwal/dev/java/DSA/output.txt")));
        int t = input.nextInt();

        while (t-- > 0) {

        }

        pw.flush();
    }
}
