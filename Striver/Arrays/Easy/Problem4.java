package Striver.Arrays.Easy;

import java.util.*;
import java.io.*;

public class Problem4 {

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

    public static int removeDuplicates(int[] nums) {
        int n = nums.length;
        int index = 0;
        int current = nums[0];

        for(int i=0;i<n; i++){
            if(nums[i] != current){
                current = nums[i];
                index+=1;
                nums[index] = current;
            }
        }

        return index + 1;
    }

    public static void main(String[] args) throws Exception {
        FastReader input = new FastReader();
        pw = new PrintWriter(new BufferedWriter(new FileWriter("D:/VSCode/DSA/output.txt")));
        int t = input.nextInt();

        while (t-- > 0) {
            int arr[] = Arrays.stream(input.nextLine().split(" ")).mapToInt(s -> Integer.parseInt(s))
                            .toArray();
            
            pw.println(removeDuplicates(arr));
            for(int i=0;i<arr.length; i++){
                pw.print(arr[i] + " ");
            }
            pw.println();
        }

        pw.flush();
    }
}
