package SearchingSorting;

import java.util.*;
import java.io.*;

public class TripletsSmallerThanX
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

    static long countTriplets(long arr[], int n,int sum)
    {
        int count=0;
        Arrays.sort(arr);

        for(int i=0;i<n-2;i++){
            int j = i+1, k = n-1;

            while(j < k){
                if(arr[i] + arr[j] + arr[k] >= sum)
                    k--;
                else{
                    count += (k-j);
                    j++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) throws Exception
    {
        FastReader input = new FastReader();
        pw = new PrintWriter(new
                BufferedWriter(new FileWriter("D:/VSCode/DSA/output.txt")));
        int t = input.nextInt();
        
        while(t-->0){
            long arr[] = Arrays.stream(input.nextLine().split(" ")).mapToLong(s -> Long.parseLong(s))
                            .toArray();
            int x = input.nextInt();

            pw.println(countTriplets(arr, arr.length, x));
        }
        
        pw.flush();
    }
}