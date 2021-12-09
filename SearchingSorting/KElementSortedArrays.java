package SearchingSorting;

import java.util.*;
import java.io.*;

public class KElementSortedArrays
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

    public static long kthElement( int arr1[], int arr2[], int n, int m, int k) {
        int i=0, j=0, k_res=0;
        while(i<n && j<m){
            if(arr1[i]<arr2[j]){
                k_res++;
                if(k_res == k)
                    return (long)arr1[i];
                i++;
            }
            else{
                k_res++;
                if(k_res == k)
                    return (long)arr2[j];
                j++;
            }
        }

        while(i < n) 
        {
            k_res++;
            if(k_res == k)
                return arr1[i];
            i++;
        }

        // If array A[] is completely traversed
        while(j < m) 
        {
            k_res++;
            if(k_res == k)
                return arr2[j];
            j++;
        }
        return -1;
    }

    public static void main(String[] args) throws Exception
    {
        FastReader input = new FastReader();
        pw = new PrintWriter(new
                BufferedWriter(new FileWriter("D:/VSCode/DSA/output.txt")));
        int t = input.nextInt();
        
        while(t-->0){
            int n = input.nextInt();
            int m = input.nextInt();
            int k = input.nextInt();

            int arr1[] = Arrays.stream(input.nextLine().split(" ")).mapToInt(s -> Integer.parseInt(s))
                            .toArray();
            int arr2[] = Arrays.stream(input.nextLine().split(" ")).mapToInt(s -> Integer.parseInt(s))
                            .toArray();

            pw.println(kthElement(arr1, arr2, n, m, k));
        }
        
        pw.flush();
    }
}