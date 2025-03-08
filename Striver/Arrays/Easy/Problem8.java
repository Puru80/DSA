package Striver.Arrays.Easy;

import java.util.*;
import java.io.*;

public class Problem8 {

    public static PrintWriter pw;

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() throws FileNotFoundException {
            br = new BufferedReader(
                    new FileReader("D:/VSCode/DSA/input.txt"));
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

    public static ArrayList<Integer> findUnion(int a[], int b[]) {
        // add your code here
        int i = 0, j = 0;
        ArrayList<Integer> res = new ArrayList<>();

        while (i < a.length && j < b.length) {
            if (a[i] < b[j]) {
                if (res.size() == 0 || res.get(res.size() - 1) != a[i])
                    res.add(a[i]);
                i++;
            } else {
                if (res.size() == 0 || res.get(res.size() - 1) != b[j])
                    res.add(b[j]);
                j++;
            }
        }

        while(i < a.length){
            if (res.get(res.size() - 1) != a[i])
                res.add(a[i]);
            i++;
        }

        while(j < b.length){
            if (res.get(res.size() - 1) != b[j])
                res.add(b[j]);
            j++;
        }

        return res;
    }

    public static void main(String[] args) throws Exception {
        FastReader input = new FastReader();
        pw = new PrintWriter(new BufferedWriter(new FileWriter("D:/VSCode/DSA/output.txt")));
        int t = input.nextInt();

        while (t-- > 0) {
            int[] a = Arrays.stream(input.nextLine().split(" ")).mapToInt(s -> Integer.parseInt(s))
                    .toArray();
            int[] b = Arrays.stream(input.nextLine().split(" ")).mapToInt(s -> Integer.parseInt(s))
                    .toArray();

            ArrayList<Integer> res = findUnion(a, b);
            for(int i: res){
                pw.print(i + " ");
            }

            pw.println();
        }

        pw.flush();
    }
}