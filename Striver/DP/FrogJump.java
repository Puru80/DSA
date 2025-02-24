package Striver.DP;

import java.util.*;
import java.io.*;

public class FrogJump {

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

    static int find(int ind, int[] height, int[] dp) {
        if (ind == 0)
            return 0;

        if (dp[ind] != -1)
            return dp[ind];

        int left = find(ind - 1, height, dp) + Math.abs(height[ind] - height[ind - 1]);
        int right = Integer.MAX_VALUE;
        if (ind > 1) {
            right = find(ind - 2, height, dp) + Math.abs(height[ind] - height[ind - 2]);
        }

        return dp[ind] = Math.min(left, right);
    }

    public static int minCost(int[] height) {
        int[] dp = new int[height.length + 1];
        Arrays.fill(dp, -1);

        return find(height.length - 1, height, dp);
    }

    public static int minCostTabulation(int[] height) {
        int n = height.length;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);

        dp[0] = 0;
        if (n > 1) {
            dp[1] = Math.abs(height[1] - height[0]);
        }

        for (int i = 2; i < n; i++) {
            dp[i] = Math.min(dp[i - 1] + Math.abs(height[i] - height[i - 1]),
                    dp[i - 2] + Math.abs(height[i] - height[i - 2]));
        }

        return dp[n-1];
    }

    public static int minCostTabulationSpaceOpt(int[] height) {
        int n = height.length;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);

        int prev2 = 0;
        int prev1 = 1;

        int cur = 0;

        for (int i = 2; i < n; i++) {
            dp[i] = Math.min(dp[i - 1] + Math.abs(height[i] - height[i - 1]),
                    dp[i - 2] + Math.abs(height[i] - height[i - 2]));

            cur = Math.min(prev1 + Math.abs(height[i] - height[i - 1]),
                    prev2 + Math.abs(height[i] - height[i - 2]));

            prev2 = prev1;
            prev1 = cur;
        }

        return cur;
    }

    public static void main(String[] args) throws Exception {
        FastReader input = new FastReader();
        pw = new PrintWriter(new BufferedWriter(new FileWriter("D:/VSCode/DSA/output.txt")));
        int t = input.nextInt();

        while (t-- > 0) {
            int[] arr = Arrays.stream(input.nextLine().split(" ")).mapToInt(s -> Integer.parseInt(s))
                    .toArray();
            pw.println(minCostTabulation(arr));
        }

        pw.flush();
    }
}