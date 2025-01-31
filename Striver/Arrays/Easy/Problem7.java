package Striver.Arrays.Easy;

import java.util.*;
import java.io.*;

public class Problem7 {

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

    public static boolean searchInSorted(int arr[], int k) {
        // Your code here

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == k)
                return true;
        }

        return false;
    }

    public static boolean binarySearch(int arr[], int k) {
        // Your code here
        int low = 0;
        int high = arr.length - 1;
        
        while(low <= high){
            int mid = (low + high)/2;

            if(arr[mid] == k){
                return true;
            }

            if(arr[mid] < k)
                low = mid + 1;
            else
                high = mid-1;
        }

        return false;
    }

    public static void main(String[] args) throws Exception {
        FastReader input = new FastReader();
        pw = new PrintWriter(new BufferedWriter(new FileWriter("D:/VSCode/DSA/output.txt")));
        int t = input.nextInt();

        while (t-- > 0) {
            int[] arr = Arrays.stream(input.nextLine().split(" ")).mapToInt(s -> Integer.parseInt(s))
                    .toArray();
            int k = input.nextInt();

            pw.println(binarySearch(arr, k));
        }

        pw.flush();
    }
}