package Arrays;

import java.util.*;
import java.io.*;

public class RotatedQueries
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

    static void solveQueries(int N, int R, int arr[], int Q, int queries[]) {
        // Write your code here
        for(int i=0;i<R;i++){
          int temp = arr[0];
          for(int j=0;j<N-1;j++){
            arr[j] = arr[j+1];
          }
          arr[N-1] = temp;
        }

        // for(int i=0;i<N;i++)
        //     pw.print(arr[i] + " ");

        // pw.println();
        
        int res[] = new int[Q];
        for(int i=0;i<Q;i++){
          res[i] = arr[queries[i]];
        }
        
        for(int i=0;i<Q;i++)
          pw.print(res[i] + " ");
      }

    public static void main(String[] args) throws Exception
    {
        FastReader input = new FastReader();
        pw = new PrintWriter(new
                BufferedWriter(new FileWriter("D:/VSCode/DSA/output.txt")));
        int t = input.nextInt();
        while(t-->0){
            int a[] = Arrays.stream(input.nextLine().split(" ")).mapToInt(s -> Integer.parseInt(s))
                            .toArray();
            int N = a[0], R = a[1];

            int[] arr = Arrays.stream(input.nextLine().split(" ")).mapToInt(s -> Integer.parseInt(s))
                            .toArray();
            int Q = input.nextInt();
            int queries[] = Arrays.stream(input.nextLine().split(" ")).mapToInt(s -> Integer.parseInt(s))
                            .toArray();

            solveQueries(N, R, arr, Q, queries);
        }
        
        pw.flush();
    }
}