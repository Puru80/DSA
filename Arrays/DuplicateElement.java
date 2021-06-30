package Arrays;

import java.util.*;
import java.io.*;

public class DuplicateElement
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

    static void Solution(int arr[])
    {

    }

    public static void main(String[] args) 
    {
        FastReader input = new FastReader();
        int t = input.nextInt();
        
        //TODO: Floyd's Hare and Tortoise Method 
        while(t-->0){
            int arr[] = Arrays.stream(input.nextLine().split(" ")).mapToInt(s -> Integer.parseInt(s))
                .toArray();

            Arrays.sort(arr);
            for(int i=0;i<arr.length-1;i++){
                if(arr[i]==arr[i+1]){
                    System.out.println(arr[i]);
                    break;
                }
            }
        
        }
        
    }
}