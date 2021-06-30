package Arrays;

import java.util.*;
import java.io.*;

public class MaxProfitFromStock
{
    static class FastReader  
    {
        BufferedReader br;
        StringTokenizer st;
     
        public FastReader()
        {
            br = new BufferedReader(
                new InputStreamReader(System.in));
        }
     
        String next()
        {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
     
        int nextInt() { return Integer.parseInt(next()); }
     
        long nextLong() { return Long.parseLong(next()); }
     
        double nextDouble()
        {
            return Double.parseDouble(next());
        }
     
        String nextLine()
        {
            String str = "";
            try {
                str = br.readLine();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

    static int Solution(int arr[])
    {
        int max_diff = arr[1] - arr[0];
        int min_element = arr[0];
        for(int i=1;i<arr.length;i++)
        {
            if(arr[i] - min_element > max_diff)
                max_diff = arr[i] - min_element;
            if(arr[i] < min_element)
                min_element = arr[i];
        }
        return max_diff;
    }

    public static void main(String[] args) 
    {
        FastReader input = new FastReader();
        int t = input.nextInt();

        while(t-->0){
            int arr[] = Arrays.stream(input.nextLine().split(" ")).mapToInt(s -> Integer.parseInt(s)).
                toArray();

            System.out.println(Solution(arr));
        }
    }
}
