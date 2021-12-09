package SearchingSorting;

import java.util.*;
import java.io.*;

public class PainterPartitionProblem
{
    public static PrintWriter pw ;

    static class FastReader  
    {
        BufferedReader br;
        StringTokenizer st;
     
        public FastReader() throws FileNotFoundException
        {
            br = new BufferedReader(
                new FileReader("D:/VSCode/DSA/input.txt"));
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

    static int numberOfPainters(int arr[], int n, int maxLen)
    {
        int total = 0, numPainters = 1;

        for (int i = 0; i < n; i++) {
            total += arr[i];

            if (total > maxLen) {

                // for next count
                total = arr[i];
                numPainters++;
            }
        }

        return numPainters;
    }

    static long minTime(int[] arr,int n,int k){
        //code here
        // Arrays.sort(arr);
        long sum = 0;
        int mid=0, max = arr[0];

        for(int i=0;i<n;i++)
            sum += arr[i];
        
        for(int i=0;i<n;i++)
            if(arr[i] > max)
                max = arr[i];

        int lo=max, hi=(int)sum;
        while(lo < hi){
            mid = (lo+hi)/2;
            int req = numberOfPainters(arr, n, mid);

            if(req <= k)
                hi = mid;
            else 
                lo = mid + 1;
        }
        return (long)lo;
    }

    public static void main(String[] args) throws Exception
    {
        FastReader input = new FastReader();
        pw = new PrintWriter(new
                BufferedWriter(new FileWriter("D:/VSCode/DSA/output.txt")));
        int t = input.nextInt();
        
        while(t-->0){
            int n = input.nextInt();
            int k = input.nextInt();
            int arr[] = Arrays.stream(input.nextLine().split(" ")).mapToInt(s -> Integer.parseInt(s))
                            .toArray();
            
            pw.println(minTime(arr, n, k));
        }
        
        pw.flush();
    }
}
