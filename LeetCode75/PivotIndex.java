package LeetCode75;

import java.util.*;
import java.io.*;

public class PivotIndex {

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

    public static int pivotIndex(int[] nums) {
        int n = nums.length;
        int rightSum = 0;
        int leftSum=0;

        for(int i=0;i<n;i++)
            rightSum += nums[i];

        for(int i=0;i<n;i++){
            if(i>0)
                leftSum += nums[i-1];
            rightSum -= nums[i];

            if(leftSum == rightSum)
                return i;
        }

        return -1;
    }

    public static void main(String[] args) throws Exception {
        FastReader input = new FastReader();
        pw = new PrintWriter(new BufferedWriter(new FileWriter("../DSA/output.txt")));
        int t = input.nextInt();

        while (t-- > 0) {
            int[] nums = Arrays.stream(input.nextLine().split(" ")).mapToInt(s -> Integer.parseInt(s))
                            .toArray();
            pw.println(pivotIndex(nums));
        }

        pw.flush();
    }
}
