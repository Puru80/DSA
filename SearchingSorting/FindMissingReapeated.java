package SearchingSorting;

import java.util.*;
import java.io.*;

public class FindMissingReapeated
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

    static int[] findTwoElement(int arr[], int n) {
        int[] res = new int[2];

        for(int i=0;i<n;i++){
            int abs_val = Math.abs(arr[i]);
            if(arr[abs_val - 1]>0)
                arr[abs_val - 1] = -arr[abs_val - 1];
            else
                res[0] = abs_val;
        }

        for(int i=0;i<n;i++)
            if(arr[i] >0)
                res[1] = i+1;

        return res;
    }

    public static void main(String[] args) throws Exception
    {
        FastReader input = new FastReader();
        pw = new PrintWriter(new
                BufferedWriter(new FileWriter("D:/VSCode/DSA/output.txt")));
        int t = input.nextInt();
        
        while(t-->0){
            int n = input.nextInt();
            int[] arr = Arrays.stream(input.nextLine().split(" ")).mapToInt(s -> 
                Integer.parseInt(s)).toArray();

            arr = findTwoElement(arr, n);
            for(int i:arr)
                pw.print(i + " ");
            pw.println();
        }
        
        pw.flush();
    }
}
