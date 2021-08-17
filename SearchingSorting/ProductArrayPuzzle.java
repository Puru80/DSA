package SearchingSorting;

import java.util.*;
import java.io.*;

public class ProductArrayPuzzle
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

    public static long[] productExceptSelf(int arr[], int n) { 
        // code here
        long res[] = new long[n];
        long p=1;
        int flag=0;

        for(int i=0;i<n;i++){
            if(arr[i]==0)
                flag++;
            else
                p *= arr[i];
        }

        for(int i=0;i<n;i++){
            if(flag>1)
                res[i] = 0;
            else if(flag==0)
                res[i] = (long)(p / arr[i]);
            else if(flag==1 && arr[i]>0)
                res[i] = 0;
            else
                res[i] = p;
        }

        return res;
	} 

    public static void main(String[] args) throws Exception
    {
        FastReader input = new FastReader();
        pw = new PrintWriter(new
                BufferedWriter(new FileWriter("D:/VSCode/DSA/output.txt")));
        int t = input.nextInt();
        
        while(t-->0){
            int arr[] = Arrays.stream(input.nextLine().split(" ")).mapToInt(s -> Integer.parseInt(s))
                            .toArray();
            
            long res[] = productExceptSelf(arr, arr.length);
            for(long i:res)
                pw.print(i + " ");
            pw.println();
        }
        
        pw.flush();
    }
}
